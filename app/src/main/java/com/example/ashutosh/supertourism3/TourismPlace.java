package com.example.ashutosh.supertourism3;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ashutosh.supertourism3.data.TourismDb;
import com.example.ashutosh.supertourism3.model.Place;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class TourismPlace extends AppCompatActivity {
    private ListView placeList;
    TourismDb db;
    MyAdapter myAdapter = new MyAdapter();
    ArrayList<Place> placeArrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapterTourismPlace;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    //private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism_place);
        db = new TourismDb(this);

        placeList = (ListView) findViewById(R.id.place_list);

        //region Description
        // textView=(TextView)findViewById(R.id.textView);

        /*
        //textView.setText((CharSequence) adventurePlace.get(0));

        Intent intent = getIntent();
        Bundle bundel = intent.getExtras();
        String type = bundel.getString("i");
        adventurePlace.addAll(db.getPlaceBasedOnTypeOfPlace(type));

        arrayAdapterAdventurePlace=new ArrayAdapter<Place>(TourismPlace.this,android.R.layout.simple_list_item_1,adventurePlace);
        placeList.setAdapter(arrayAdapterAdventurePlace);*/
        //endregion


        Intent intent = getIntent();
        Bundle bundel = intent.getExtras();
        String type = bundel.getString("i");

        placeArrayList.addAll(db.getPlaceBasedOnTypeOfPlace(type));

        placeList.setAdapter(myAdapter);/*
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();*/
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return placeArrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return placeArrayList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {


            Place p = placeArrayList.get(i);

            View v = getLayoutInflater().inflate(R.layout.place_row, viewGroup, false);
            TextView placeType = (TextView) v.findViewById(R.id.place_type);
            TextView placeName = (TextView) v.findViewById(R.id.place_name);
           /* ImageView placeImage=(ImageView)v.findViewById(R.id.place_image);*/

            placeType.setText(p.getType());
            placeName.setText(p.getName());
            // placeImage.setImageBitmap();


            return v;
        }
    }
}
