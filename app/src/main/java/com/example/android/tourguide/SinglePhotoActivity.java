package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class SinglePhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_photo_view);

        Bundle extras = getIntent().getExtras();
        int entryId = extras.getInt("resource_id");
        String actionBarTitle = extras.getString("action_bar_title");

        ImageView photoHd = (ImageView) findViewById(R.id.photo_view);
        photoHd.setImageResource(entryId);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(actionBarTitle);
    }
}
