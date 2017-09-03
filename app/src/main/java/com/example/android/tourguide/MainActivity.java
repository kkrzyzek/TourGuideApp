package com.example.android.tourguide;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import static android.media.AudioManager.AUDIOFOCUS_GAIN;
import static android.media.AudioManager.AUDIOFOCUS_LOSS;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    private boolean flag;

    private AudioManager mAudioManager;
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int audioFocusChange) {
            if (audioFocusChange == AUDIOFOCUS_GAIN) {
                mMediaPlayer.setVolume(1.0f, 1.0f);
                mMediaPlayer.start();
            }else if (audioFocusChange == AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }else if (audioFocusChange == AUDIOFOCUS_LOSS_TRANSIENT) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }else if (audioFocusChange == AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.setVolume(0.2f, 0.2f);
            }
        }
    };

    private int mCurrentImage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        final ImageView panorama = (ImageView) findViewById(R.id.panorama_view);
        panorama.setImageResource(R.drawable.panorama_final);
        panorama.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mCurrentImage++;
                switch (mCurrentImage) {
                    case 1: panorama.setImageResource(R.drawable.panorama1);
                        break;
                    case 2: panorama.setImageResource(R.drawable.panorama2);
                        break;
                    case 3: panorama.setImageResource(R.drawable.panorama3);
                            panorama.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        break;
                    case 4: panorama.setImageResource(R.drawable.panorama_final);
                            panorama.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            mCurrentImage = 0;
                        break;
                }
            }
        });

        RelativeLayout mapButton = (RelativeLayout) findViewById(R.id.map_button);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri mapUri = Uri.parse("geo:50.065,19.94?q=Krakow");
                Intent i = new Intent(Intent.ACTION_VIEW, mapUri);
                startActivity(i);
            }
        });

        RelativeLayout toSeeButton = (RelativeLayout) findViewById(R.id.to_see_button);
        toSeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), ToSeeActivity.class);
                startActivity(i);
            }
        });

        final RelativeLayout restaurantsButton = (RelativeLayout) findViewById(R.id.restaurants_button);
        restaurantsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), RestaurantsActivity.class);
                startActivity(i);
            }
        });

        RelativeLayout photosButton = (RelativeLayout) findViewById(R.id.photos_button);
        photosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), PhotosActivity.class);
                startActivity(i);
            }
        });

        RelativeLayout trumpetCallButton= (RelativeLayout) findViewById(R.id.trumpet_call_button);
        trumpetCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int audioFocusStatus = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

                if (audioFocusStatus == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    if (!flag) {

                        releaseMediaPlayer();
                        mMediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.trumpet_call);
                        mMediaPlayer.start();
                        flag = true;
                        Toast.makeText(MainActivity.this, "Krakow Trumpet Call is playing.", Toast.LENGTH_SHORT).show();

                        mMediaPlayer.setOnCompletionListener(mCompletionListener);
                    } else {
                        mMediaPlayer.stop();
                        Toast.makeText(MainActivity.this, "Krakow Trumpet Call stopped playing.", Toast.LENGTH_SHORT).show();
                        flag = false;
                        releaseMediaPlayer();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Cannot play Krakow Trumpet Call. Try Again.", Toast.LENGTH_LONG).show();
                }
            }
        });

        RelativeLayout appInfoButton = (RelativeLayout) findViewById(R.id.app_info_button);
        appInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), AppInfoActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        flag = false;
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}
