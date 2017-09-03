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
public class MariackiFragment extends Fragment {


    public MariackiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final Monument mariacki = new Monument("Mariacki Church", "https://en.wikipedia.org/wiki/St._Mary%27s_Basilica,_Krak%C3%B3w",
                                        getResources().getString(R.string.mariacki_short_description),
                                        getResources().getString(R.string.mariacki_long_description),
                                        R.drawable.mariacki1, R.drawable.mariacki2);

        View rootView = inflater.inflate(R.layout.single_to_see_view, container, false);

        TextView monumentName = (TextView) rootView.findViewById(R.id.monument_name);
        monumentName.setText(mariacki.getMonumentName());

        TextView monumentShortDescription = (TextView) rootView.findViewById(R.id.monument_description);
        monumentShortDescription.setText(mariacki.getMonumentShortDescription());

        TextView monumentLongDescription = (TextView) rootView.findViewById(R.id.monument_long_description);
        monumentLongDescription.setText(mariacki.getMonumentLongDescription());

        ImageView image1 = (ImageView) rootView.findViewById(R.id.monument_image);
        image1.setImageResource(mariacki.getMonumentImage1ResourceId());

        ImageView image2 = (ImageView) rootView.findViewById(R.id.monument_large_image);
        image2.setImageResource(mariacki.getMonumentImage2ResourceId());

        LinearLayout websiteButton = (LinearLayout) rootView.findViewById(R.id.monument_website);
        websiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = mariacki.getMonumentWebsite();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        return rootView;
    }

}
