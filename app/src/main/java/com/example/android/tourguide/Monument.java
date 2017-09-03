package com.example.android.tourguide;

/**
 * Created by user on 2017-08-31.
 */

public class Monument {

    private String mMonumentName;
    private String mMonumentWebsite;
    private String mMonumentShortDescription;
    private String mMonumentLongDescription;

    private int mMonumentImage1ResourceId;
    private int mMonumentImage2ResourceId;

    public Monument (String monumentName, String monumentWebsite, String monumentShortDescription,
                     String monumentLongDescription, int monumentImage1ResourceId, int monumentImage2ResourceId) {
        mMonumentName = monumentName;
        mMonumentWebsite = monumentWebsite;
        mMonumentShortDescription = monumentShortDescription;
        mMonumentLongDescription = monumentLongDescription;
        mMonumentImage1ResourceId = monumentImage1ResourceId;
        mMonumentImage2ResourceId = monumentImage2ResourceId;
    }



    public String getMonumentName() {
        return mMonumentName;
    }

    public String getMonumentWebsite() {
        return mMonumentWebsite;
    }

    public String getMonumentShortDescription() {
        return mMonumentShortDescription;
    }

    public String getMonumentLongDescription() {
        return mMonumentLongDescription;
    }

    public int getMonumentImage1ResourceId() {
        return mMonumentImage1ResourceId;
    }

    public int getMonumentImage2ResourceId() {
        return mMonumentImage2ResourceId;
    }


    public void setMonumentName(String mMonumentName) {
        this.mMonumentName = mMonumentName;
    }

    public void setMonumentWebsite(String mMonumentWebsite) {
        this.mMonumentWebsite = mMonumentWebsite;
    }

    public void setMonumentShortDescription(String mMonumentShortDescription) {
        this.mMonumentShortDescription = mMonumentShortDescription;
    }

    public void setMonumentLongDescription(String mMonumentLongDescription) {
        this.mMonumentLongDescription = mMonumentLongDescription;
    }

    public void setMonumentImage1ResourceId(int mMonumentImage1ResourceId) {
        this.mMonumentImage1ResourceId = mMonumentImage1ResourceId;
    }

    public void setMonumentImage2ResourceId(int mMonumentImage2ResourceId) {
        this.mMonumentImage2ResourceId = mMonumentImage2ResourceId;
    }

    @Override
    public String toString() {
        return "Monument: " + "mMonumentName= '" + mMonumentName + "', " +
                "mMonumentShortDescription= '" + mMonumentShortDescription + "', " +
                "mMonumentLongDescription= '" + mMonumentLongDescription + "', " +
                "mMonumentWebsite= '" + mMonumentWebsite + "', " +
                "mMonumentImage1ResourceId= '" + mMonumentImage1ResourceId + "', " +
                "mMonumentImage2ResourceId= '" + mMonumentImage2ResourceId;
    }
}

