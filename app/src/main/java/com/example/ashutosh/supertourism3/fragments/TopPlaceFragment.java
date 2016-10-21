package com.example.ashutosh.supertourism3.fragments;


import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ashutosh.supertourism3.AboutTopTourism;
import com.example.ashutosh.supertourism3.AddNewPlace;
import com.example.ashutosh.supertourism3.R;
import com.example.ashutosh.supertourism3.model.TopPlace;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopPlaceFragment extends Fragment {

    ListView listViewTopPlace;
    private ArrayList<TopPlace> topPlaceArrayList = new ArrayList<>();
    private String[] topPlaceName = {"Hampi Village", "Hebbe Falls", "Lalbaag", "National Park", "Tipu Sultan Palace",};
    //private int[] topPlaceImage = {R.drawable.bangalore_fort, R.drawable.hebbe_falls, R.drawable.lalbag,R.drawable.national_park,R.drawable.tipu_palace};
    private MyAdapter myAdapter;

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return topPlaceArrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return topPlaceArrayList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View v = getActivity().getLayoutInflater().inflate(R.layout.row, null);
            final TopPlace tp = topPlaceArrayList.get(i);
            TextView textPlaceName = (TextView) v.findViewById(R.id.place_text);
            ImageView placeImage = (ImageView) v.findViewById(R.id.place_image);

            textPlaceName.setText(tp.getPlaceName());
            // placeImage.setImageResource(tp.getImageId());
            //Bit map
            Bitmap bitmap = decodeSampledBitmapFromResource(getResources(), tp.getImageId(), 100, 100);
            placeImage.setImageBitmap(bitmap);

            return v;
        }
    }



    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }


    public TopPlaceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_place, container, false);
        listViewTopPlace = (ListView) view.findViewById(R.id.listViewTopPlace);
        populateTopPlaceList();
        myAdapter = new MyAdapter();
        listViewTopPlace.setAdapter(myAdapter);

        listViewTopPlace.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), AboutTopTourism.class);
                intent.putExtra("topPlaceName", topPlaceName[i]);
                //intent.putExtra("topPlaceImage",topPlaceName);
                startActivity(intent);
            }
        });

        return view;
    }

    private void populateTopPlaceList() {
        topPlaceArrayList.add(new TopPlace("Hampi Village", R.drawable.hampi));
        topPlaceArrayList.add(new TopPlace("Hebbe Falls", R.drawable.hebbe_falls));
        topPlaceArrayList.add(new TopPlace("Lalbaag", R.drawable.lalbag));
        topPlaceArrayList.add(new TopPlace("National Park", R.drawable.national_park));
        topPlaceArrayList.add(new TopPlace("Tipu Sultan palace", R.drawable.tipu_palace));
    }

}
