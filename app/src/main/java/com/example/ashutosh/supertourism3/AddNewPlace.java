package com.example.ashutosh.supertourism3;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ashutosh.supertourism3.data.ContractTourism;
import com.example.ashutosh.supertourism3.data.TourismDb;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddNewPlace extends AppCompatActivity {

    Bitmap photo;
    Spinner spinner;
    EditText editTextPlaceName, editTextSummary;
    Button addButton, addGallery;
    ImageButton addImage;
    ImageView imageView;
    TourismDb db;
    private static final int SELECTED_PICTURE = 1;
    Uri uri;
    private static final int CAMERA_REQUEST = 1888;
    private Bitmap newImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_place);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Add New Place...");

        db = new TourismDb(this);
        imageView = (ImageView) findViewById(R.id.imageView);
        editTextPlaceName = (EditText) findViewById(R.id.editTextPlaceName);
        editTextSummary = (EditText) findViewById(R.id.edit_text_summary);
        addButton = (Button) findViewById(R.id.addButton);
        addImage = (ImageButton) findViewById(R.id.addImage);
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
                String placeSummary = editTextSummary.getText().toString();

                File folder = null, file = null;

                if(photo!=null){
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    FileOutputStream fileOutputStream=null;

                    photo.compress(Bitmap.CompressFormat.JPEG, 60,byteArrayOutputStream);

                    folder=new File(Environment.getExternalStorageDirectory()+File.separator+"SuperTourism"+File.separator+
                            tourismType+File.separator);

                    boolean success = true;
                    if(!folder.exists()){
                        success = folder.mkdirs();
                    }

                    if(success){
                        try {
                            file = new File(folder+File.separator+placeName+".jpg");
                            file.createNewFile();
                            fileOutputStream = new FileOutputStream(file);
                            fileOutputStream.write(byteArrayOutputStream.toByteArray());

                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }
                Toast.makeText(AddNewPlace.this, file.getAbsolutePath(), Toast.LENGTH_SHORT).show();

                /*ByteArrayOutputStream stream = new ByteArrayOutputStream();
                newImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();*/


///////////////////////////////////////////////////********************///////////

                long result = db.insertPlace(tourismType, placeName, placeSummary, null);

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

    public void addGalleryImage(View v) {
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, SELECTED_PICTURE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST) {
        }


        switch (requestCode) {
            case SELECTED_PICTURE:
                if (resultCode == RESULT_OK && requestCode == SELECTED_PICTURE) {
                    uri = data.getData();
                    String[] projection = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(projection[0]);
                    String filePath = cursor.getString(columnIndex);
                    cursor.close();

                    photo = BitmapFactory.decodeFile(filePath);
                    //Drawable d = new BitmapDrawable(yourSelectedImage);
                    imageView.setImageBitmap(photo);
                }
                break;
            case CAMERA_REQUEST:
                if (resultCode == RESULT_OK) {

                    photo = (Bitmap) data.getExtras().get("data");
                    imageView.setImageBitmap(photo);
                    //ByteArrayOutputStream stream=new ByteArrayOutputStream();
                    //byte[] byteArray=stream.toByteArray();

                    /*ByteArrayOutputStream baoStream = new ByteArrayOutputStream();
                    photo.compress(Bitmap.CompressFormat.PNG, 100, baoStream);

                    byte[] bytesImage = baoStream.toByteArray();
                    newImage = BitmapFactory.decodeByteArray(bytesImage, 0, bytesImage.length);*/
                }
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
