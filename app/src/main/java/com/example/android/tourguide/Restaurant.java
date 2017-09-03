package com.example.android.tourguide;

/**
 * Created by user on 2017-08-30.
 */

public class Restaurant {

    private String mRestaurantName;
    private String mRestaurantDescription;
    private int mRestaurantImageResourceId;
    private String mRestaurantUrl;

    public Restaurant (String restaurantName, String restaurantDescription, int restaurantImageResourceId, String restaurantUrl) {
        mRestaurantName = restaurantName;
        mRestaurantDescription = restaurantDescription;
        mRestaurantImageResourceId = restaurantImageResourceId;
        mRestaurantUrl = restaurantUrl;
    }
    
    public String getRestaurantName() {
        return mRestaurantName;
    }
    
    public String getRestaurantDescription() {
        return mRestaurantDescription;
    }

    public int getRestaurantImageResourceId() {
        return mRestaurantImageResourceId;
    }

    public String getRestaurantUrl() {
        return mRestaurantUrl;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                " mRestaurantName= '" + mRestaurantName + "', " +
                " mRestaurantDescription= '" + mRestaurantDescription + "', " +
                " mRestaurantRestaurantImageResourceId= '" + mRestaurantImageResourceId +
                " mRestaurantUrl= '" + mRestaurantUrl + "'.";
    }
}
