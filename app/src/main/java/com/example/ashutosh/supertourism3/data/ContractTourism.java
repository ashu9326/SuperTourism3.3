package com.example.ashutosh.supertourism3.data;

import android.provider.BaseColumns;

/**
 * Created by Ashutosh on 05-10-2016.
 */
public class ContractTourism {
    public ContractTourism() {
    }
    public static class TourismPlace implements BaseColumns {
        public static final String TABLE_NAME = "place";
        public static final String COLUMN_TOURISM_TYPE = "type";
        public static final String COLUMN_TOURISM_NAME = "name";
        public static final String COLUMN_TOURISM_PLACE_IMAGE = "image";
        public static final String COLUMN_TOURISM_PLACE_SUMMARY = "summary";

    }
}
