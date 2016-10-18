package com.example.ashutosh.supertourism3;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ashutosh.supertourism3.data.ContractTourism;
import com.example.ashutosh.supertourism3.data.TourismDb;

import java.io.ByteArrayOutputStream;

public class AddNewPlace extends AppCompatActivity {

    Bitmap photo;
    Spinner spinner;
    EditText editTextPlaceName, editTextSummary;
    Button addButton, addImage;
    ImageView imageView;
    TourismDb  db;
    private static final int CAMERA_REQUEST = 1888;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_place);


        db = new TourismDb(this);
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


        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });



        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TourismDbHelper helper = new TourismDbHelper(AddNewPlace.this);

                String tourismType = (String) spinner.getSelectedItem();
                String placeName = editTextPlaceName.getText().toString();
                String placeSummary=editTextSummary.getText().toString();

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                photo.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();


                long result = db.insertPlace(tourismType, placeName, placeSummary, byteArray);

                if (result > -1) {
                    Toast.makeText(AddNewPlace.this, "Place inserted", Toast.LENGTH_SHORT).show();
                }

                /*ContentValues contentValues = new ContentValues();
                contentValues.put(ContractTourism.TourismPlace.COLUMN_TOURISM_TYPE, String.valueOf(spinner));
                contentValues.put(ContractTourism.TourismPlace.COLUMN_TOURISM_NAME, String.valueOf(editTextPlaceName));
                contentValues.put(ContractTourism.TourismPlace.COLUMN_TOURISM_PLACE_SUMMARY, String.valueOf(editTextSummary));

                // Opening connection to database
                SQLiteDatabase database = helper.getWritableDatabase();

                // Insert data
                database.insert(ContractTourism.TourismPlace.TABLE_NAME, null, contentValues);

                // Close database connection
                database.close();
                helper.close();*/
            }
        });
        // readFromDatabaseAndUpdateListView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAMERA_REQUEST) {
            photo= (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
            ByteArrayOutputStream stream=new ByteArrayOutputStream();
            byte[] byteArray=stream.toByteArray();
        }
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        Spinner spinner = (Spinner) findViewById(R.id.spinner_tourism_type);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

}
