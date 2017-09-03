package com.example.android.tourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 2017-08-30.
 */

public class RestaurantAdapter extends ArrayAdapter<Restaurant> {

    ArrayList<Restaurant> mRestaurants;

    public RestaurantAdapter(Context context, ArrayList<Restaurant> restaurants) {
        super(context, 0, restaurants);
        mRestaurants = restaurants;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.single_restaurant_view, parent, false);
        }

        Restaurant currentRestaurant = getItem(position);

        TextView textView0 = (TextView) listItemView.findViewById(R.id.text_view0);
        textView0.setText("No. " + (position + 1));

        TextView textView = (TextView) listItemView.findViewById(R.id.text_view);
        textView.setText(currentRestaurant.getRestaurantName());

        TextView textView1 = (TextView) listItemView.findViewById(R.id.text_view_3);
        textView1.setText(currentRestaurant.getRestaurantDescription());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        imageView.setImageResource(currentRestaurant.getRestaurantImageResourceId());

        return listItemView;
    }
}
