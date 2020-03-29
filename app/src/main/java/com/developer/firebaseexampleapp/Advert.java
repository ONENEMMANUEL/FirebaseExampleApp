package com.developer.firebaseexampleapp;

public class Advert {
    private String mName;
    private String mImageUrl;

    public Advert() {
    }

    public Advert(String mName, String mImageUrl) {
        this.mName = mName;
        this.mImageUrl = mImageUrl;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}
