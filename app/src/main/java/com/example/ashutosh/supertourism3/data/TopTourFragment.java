package com.example.ashutosh.supertourism3.data;


//import android.app.ListFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ashutosh.supertourism3.AddNewPlace;
import com.example.ashutosh.supertourism3.R;
import com.example.ashutosh.supertourism3.TourismPlace;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopTourFragment extends ListFragment {
    public TopTourFragment() {
    }

    //region fragment old code
  /*  public TopTourFragment() {
        // Required empty public constructor
    }
*/

    //region code for floating point button
   /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_top_tour,container, false);
        floatingActionButton = (FloatingActionButton)v.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddNewPlace.class);
                startActivity(intent);
            }
        });
        return v;
    }*/
    //endregion


    //endregion
    String[] typeOfTour = new String[]{"Adventure", "Ecotourism", "Historical", "Industrial Tourism", "Religious Tourism"};
    FloatingActionButton floatingActionButton;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, typeOfTour);
        setListAdapter(adapter);

    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(getActivity(), TourismPlace.class);
        //intent.putExtra("typeOfTour", typeOfTour[position]);
        //intent.putExtra("position", position);
        startActivity(intent);
    }
}
