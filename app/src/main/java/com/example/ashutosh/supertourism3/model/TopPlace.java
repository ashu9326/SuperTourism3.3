package com.example.ashutosh.supertourism3.model;

/**
 * Created by Ashutosh on 06-10-2016.
 */
public class TopPlace {
    private String placeName;
    private  int imageId;

    public TopPlace(String placeName, int imageId) {
        this.placeName = placeName;
        this.imageId = imageId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
