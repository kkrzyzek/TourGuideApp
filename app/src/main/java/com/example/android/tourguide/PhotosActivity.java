package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

public class PhotosActivity extends AppCompatActivity {

    private int mPhotoResourceId;
    private int mPhotoHdResourceId;

    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        

        final ArrayList<Integer> mPhotos = new ArrayList<Integer>();
        final ArrayList<Integer> mPhotosHd = new ArrayList<Integer>();

        String[] actionBarTitles = getResources().getStringArray(R.array.photos_view_action_bar_title);
        final ArrayList<String> mActionBarTitles = new ArrayList<String>(Arrays.asList(actionBarTitles));

       while(i<16) {
           mPhotoResourceId = getResources().getIdentifier("photo" + i, "drawable", getPackageName());
           mPhotos.add(mPhotoResourceId);

           mPhotoHdResourceId = getResources().getIdentifier("photo_hd_" + i, "drawable", getPackageName());
           mPhotosHd.add(mPhotoHdResourceId);

           i++;
       }

       //Log.i("PhotosActivity.java", "PhotoHd(4) R.id = " + mPhotosHd.get(4));

        GridView gridView = (GridView) findViewById(R.id.grid_view);
        gridView.setAdapter(new ImageAdapter(this, mPhotos)); //sets ImageAdapter as source for all items to be displayed in the grid

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Integer photoHd = mPhotosHd.get(position);
                String actionBarTitle = mActionBarTitles.get(position);

                Intent intent = new Intent(view.getContext(), SinglePhotoActivity.class);
                intent.putExtra("resource_id", photoHd);
                intent.putExtra("action_bar_title", actionBarTitle);
                startActivity(intent);
            }
        });
    }
}
