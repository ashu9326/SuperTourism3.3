package com.example.ashutosh.supertourism3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.ashutosh.supertourism3.data.TourismDb;

public class AddNewPlace extends AppCompatActivity {
    Spinner spinner;
    EditText editTextPlaceName, editTextSummary;
    Button addButton, addImage;
    ImageView imageView;
    TourismDb db;
    private static final int CAMERA_REQUEST = 1888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_place);
        imageView = (ImageView) findViewById(R.id.imageView);
        editTextPlaceName = (EditText) findViewById(R.id.editTextPlaceName);
        editTextSummary = (EditText) findViewById(R.id.edit_text_summary);
        addButton = (Button) findViewById(R.id.addButton);
        addImage = (Button) findViewById(R.id.addImage);
        spinner = (Spinner) findViewById(R.id.spinner_tourism_type);
        // Create an ArrayAdapter using the string array and a default spinner layout
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tourism_type_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }
}
