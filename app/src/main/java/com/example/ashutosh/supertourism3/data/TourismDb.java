package com.example.ashutosh.supertourism3.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.ashutosh.supertourism3.model.Place;

import java.util.ArrayList;

/**
 * Created by Ashutosh on 05-10-2016.
 */
public class TourismDb {
    public SQLiteDatabase database;
    private TourismDbHelper helper;

    public TourismDb(Context context) {
        helper = new TourismDbHelper(context);
    }

    public SQLiteDatabase openReadableDatabaseInstance() {
        return helper.getReadableDatabase();
    }

    private SQLiteDatabase openWritableDatabaseInstance() {
        return helper.getWritableDatabase();
    }

    public void closeDatabaseConnection() {
        database.close();
        helper.close();
    }
//ashu

    //region to get type of placeName and other columu value
   /* public ArrayList<Place> getPlaceBasedOnTypeOfPlace(String typeOfPlace){

        database = openReadableDatabaseInstance();

        *//*
        Which columns you want in your cursor
         *//*
        String[] projections = null; //{ContractTourism.TourismPlace.COLUMN_TOURISM_NAME};

        String selection = ContractTourism.TourismPlace.COLUMN_TOURISM_TYPE +" = ? ";
        String[] selectionArgs = {typeOfPlace};

        Cursor cursor = database.query(ContractTourism.TourismPlace.TABLE_NAME, projections, selection, selectionArgs,
                null, null, null);

        ArrayList<Place> arrayList = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                String name = cursor.getString(cursor.getColumnIndex(ContractTourism.TourismPlace.COLUMN_TOURISM_NAME));
                String type = cursor.getString(cursor.getColumnIndex(ContractTourism.TourismPlace.COLUMN_TOURISM_TYPE));
                String summary = cursor.getString(cursor.getColumnIndex(ContractTourism.TourismPlace.COLUMN_TOURISM_PLACE_SUMMARY));
                String image = cursor.getString(cursor.getColumnIndex(ContractTourism.TourismPlace.COLUMN_TOURISM_PLACE_IMAGE));
                String link = cursor.getString(cursor.getColumnIndex(ContractTourism.TourismPlace.COLUMN_TOURISM_LINK));

                Place place = new Place(type, name, summary, image, link);
                arrayList.add(place);

            } while (cursor.moveToNext());
        }

        closeDatabaseConnection();

        return arrayList;
    }*/
    //endregion

    public ArrayList<Place> getPlaceBasedOnTypeOfPlace(String typeOfPlace){

        database = openReadableDatabaseInstance();

        /*
        Which columns you want in your cursor
         */
        String[] projections = {ContractTourism.TourismPlace.COLUMN_TOURISM_TYPE,ContractTourism.TourismPlace.COLUMN_TOURISM_NAME}; //null

        String selection = ContractTourism.TourismPlace.COLUMN_TOURISM_TYPE +" = ? ";
        String[] selectionArgs = {typeOfPlace};

        Cursor cursor = database.query(ContractTourism.TourismPlace.TABLE_NAME, null, selection, selectionArgs,
                null, null, null);

        ArrayList<Place> arrayList = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                String type = cursor.getString(cursor.getColumnIndex(ContractTourism.TourismPlace.COLUMN_TOURISM_TYPE));
                String name = cursor.getString(cursor.getColumnIndex(ContractTourism.TourismPlace.COLUMN_TOURISM_NAME));
                String summary = cursor.getString(cursor.getColumnIndex(ContractTourism.TourismPlace.COLUMN_TOURISM_PLACE_SUMMARY));
                //String image = cursor.getBlob(cursor.getColumnIndex(ContractTourism.TourismPlace.COLUMN_TOURISM_PLACE_IMAGE));
                byte[] bytes=cursor.getBlob(cursor.getColumnIndex(ContractTourism.TourismPlace.COLUMN_TOURISM_PLACE_IMAGE));

                Bitmap image = BitmapFactory.decodeByteArray(bytes, 0, 0);

                Place place = new Place(type, name,summary,image);
                arrayList.add(place);

            } while (cursor.moveToNext());
        }

        closeDatabaseConnection();

        return arrayList;
    }

    public ArrayList<Place> getAllPlaces(){

        database = openReadableDatabaseInstance();

        Cursor cursor = database.query(ContractTourism.TourismPlace.TABLE_NAME, null, null, null, null, null, null);

        ArrayList<Place> arrayList = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                String name = cursor.getString(cursor.getColumnIndex(ContractTourism.TourismPlace.COLUMN_TOURISM_NAME));
                String type = cursor.getString(cursor.getColumnIndex(ContractTourism.TourismPlace.COLUMN_TOURISM_TYPE));
                String summary = cursor.getString(cursor.getColumnIndex(ContractTourism.TourismPlace.COLUMN_TOURISM_PLACE_SUMMARY));

                byte[] bytes=cursor.getBlob(cursor.getColumnIndex(ContractTourism.TourismPlace.COLUMN_TOURISM_PLACE_IMAGE));

                Bitmap image = BitmapFactory.decodeByteArray(bytes, 0, 0);

                Place place = new Place(type, name,summary,image);
                arrayList.add(place);

            } while (cursor.moveToNext());
        }

        closeDatabaseConnection();

        return arrayList;

    }

    public long insertPlace(String type, String name, String summary, byte[] imageLocation){
        database = openWritableDatabaseInstance();

        ContentValues cv = new ContentValues();
        cv.put(ContractTourism.TourismPlace.COLUMN_TOURISM_TYPE, type);
        cv.put(ContractTourism.TourismPlace.COLUMN_TOURISM_NAME, name);
        cv.put(ContractTourism.TourismPlace.COLUMN_TOURISM_PLACE_IMAGE, imageLocation);
        cv.put(ContractTourism.TourismPlace.COLUMN_TOURISM_PLACE_SUMMARY, summary);

        long result = database.insert(ContractTourism.TourismPlace.TABLE_NAME, null, cv);

        closeDatabaseConnection();

        return result;

    }

    public class TourismDbHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "tourism.db";
        private static final int DATABASE_VERSION = 2;

        private String SQL_CREATE_TOURISM_TABLE = "CREATE TABLE " + ContractTourism.TourismPlace.TABLE_NAME + "("
                + ContractTourism.TourismPlace._ID + " INTEGER PRIMARY KEY,"
                + ContractTourism.TourismPlace.COLUMN_TOURISM_TYPE + " TEXT NOT NULL,"
                + ContractTourism.TourismPlace.COLUMN_TOURISM_NAME + " TEXT DEFAULT NULL,"
                + ContractTourism.TourismPlace.COLUMN_TOURISM_PLACE_IMAGE + " BLOB DEFAULT NULL,"
                + ContractTourism.TourismPlace.COLUMN_TOURISM_PLACE_SUMMARY + " TEXT DEFAULT NULL);";

        private String SQL_DROP_TOURISM_TABLE = "DROP TABLE " + ContractTourism.TourismPlace.TABLE_NAME + ";";

        public TourismDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_TOURISM_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if (oldVersion < newVersion) {
                db.execSQL(SQL_DROP_TOURISM_TABLE);
                onCreate(db);
            }
        }
    }
}
