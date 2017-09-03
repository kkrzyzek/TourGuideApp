package com.example.android.tourguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WawelFragment extends Fragment {


    public WawelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final Monument wawel = new Monument("Wawel Castle", "https://en.wikipedia.org/wiki/Wawel",
                                    getResources().getString(R.string.wawel_short_description),
                                    getResources().getString(R.string.wawel_long_description),
                                    R.drawable.wawel1, R.drawable.wawel2);

        View rootView = inflater.inflate(R.layout.single_to_see_view, container, false);

        TextView monumentName = (TextView) rootView.findViewById(R.id.monument_name);
        monumentName.setText(wawel.getMonumentName());

        TextView monumentShortDescription = (TextView) rootView.findViewById(R.id.monument_description);
        monumentShortDescription.setText(wawel.getMonumentShortDescription());

        TextView monumentLongDescription = (TextView) rootView.findViewById(R.id.monument_long_description);
        monumentLongDescription.setText(wawel.getMonumentLongDescription());

        ImageView image1 = (ImageView) rootView.findViewById(R.id.monument_image);
        image1.setImageResource(wawel.getMonumentImage1ResourceId());

        ImageView image2 = (ImageView) rootView.findViewById(R.id.monument_large_image);
        image2.setImageResource(wawel.getMonumentImage2ResourceId());

        LinearLayout websiteButton = (LinearLayout) rootView.findViewById(R.id.monument_website);
        websiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = wawel.getMonumentWebsite();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        return rootView;
    }

}
