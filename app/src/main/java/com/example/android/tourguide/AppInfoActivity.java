package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class AppInfoActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info);

        EditText messageText = (EditText) findViewById(R.id.mail_text_view);
        messageText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    String text = textView.getText().toString();
                    sendMessage(text);
                }
                return false;
            }
        });

        ImageView facebookLogo = (ImageView) findViewById(R.id.facebook_image_view);
        facebookLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Code snippet - facebook profile intent
                try {
                    getApplicationContext().getPackageManager()
                            .getPackageInfo("com.facebook.katana", 0); //Checks if FB is even installed.
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("fb://profile/100015356255671")); //Tries to make intent with FB's URI
                    startActivity(intent);
                } catch (Exception e) {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.facebook.com/profile.php?id=100015356255671")); //catches and opens an url to the desired page
                    startActivity(intent);
                }
            }
            });

    }

    private void sendMessage(String message) {
        String mailto = "mailto:krzyzek.krzysztof@gmail.com" +
                "?cc=" + "" +
                "&subject=" + Uri.encode("Mail from user, regarding TourGuide App") +
                "&body=" + Uri.encode(message);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse(mailto));
        startActivity(intent);
    }
}