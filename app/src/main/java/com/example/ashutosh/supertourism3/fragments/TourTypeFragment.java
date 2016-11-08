package com.example.ashutosh.supertourism3.fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ashutosh.supertourism3.AddNewPlace;
import com.example.ashutosh.supertourism3.R;
import com.example.ashutosh.supertourism3.TourismPlace;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TourTypeFragment extends Fragment {


    public TourTypeFragment() {
        // Required empty public constructor
    }

    private ListView  listViewTourType;
    String[] tourType = new String[]{"Adventure", "Ecotourism", "Historical", "Industrial Tourism", "Religious Tourism"};
    ArrayAdapter<String> arrayAdapterTourType;
    //ArrayList<String> arrayListTourType=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_tour_type, container, false);
        listViewTourType=(ListView)v.findViewById(R.id.list_view_tour_type);
        /*arrayListTourType.add(tourType[0]);
        arrayListTourType.add(tourType[1]);
        arrayListTourType.add(tourType[2]);
        arrayListTourType.add(tourType[3]);
        arrayListTourType.add(tourType[4]);*/

        arrayAdapterTourType=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,tourType);
        listViewTourType.setAdapter(arrayAdapterTourType);
        listViewTourType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(),TourismPlace.class);
                intent.putExtra("i",tourType[i]);
                startActivity(intent);
            }
        });


        return v;
    }

}
