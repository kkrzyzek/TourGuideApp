package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class RestaurantsActivity extends AppCompatActivity {

    private int mImageResourceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);


        String[] restaurantsCousineArray = getResources().getStringArray(R.array.restaurants_cousine);
        ArrayList<String> restaurantsDescription = new ArrayList<String> (Arrays.asList(restaurantsCousineArray));

        String[] restaurantsNameArray = getResources().getStringArray(R.array.restaurants_name);
        ArrayList<String> restaurantsName = new ArrayList<String>(Arrays.asList(restaurantsNameArray));

        String[] restaurantsUrlArray = getResources().getStringArray(R.array.restaurants_website);
        ArrayList<String> restaurantsUrl = new ArrayList<String>(Arrays.asList(restaurantsUrlArray));

        final ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();

        for (int i=1; i<restaurantsName.size(); i++) {
            mImageResourceId = getResources().getIdentifier("restaurant" + i, "drawable", getPackageName());
            restaurants.add(new Restaurant(restaurantsName.get(i), restaurantsDescription.get(i), mImageResourceId, restaurantsUrl.get(i)));
        }

        RestaurantAdapter restaurantAdapter = new RestaurantAdapter(this, restaurants);

        ListView restaurantsListView = (ListView) findViewById(R.id.restaurants_list_view);
        restaurantsListView.setAdapter(restaurantAdapter);

        //Log.i("RestaurantsActivity", restaurants.get(0).toString());

        restaurantsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String restaurantUrl = restaurants.get(position).getRestaurantUrl();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(restaurantUrl));
                startActivity(i);
            }
        });
    }
}
