package com.example.dell.music_player_app_19_june;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mediaPlayer;
    Button b1, b2, b3, b4, b5, b6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = mediaPlayer.create(this, R.raw.camila_cabello_havana_song);
        b1 = findViewById(R.id.start);
        b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.stop);
        b2.setOnClickListener(this);
        b4 = (Button) findViewById(R.id.pause);
        b4.setOnClickListener(this);
    }

    int length,fg = 0;

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.start:
                Toast toast = Toast.makeText(getApplicationContext(),
                        " Music Started", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
                if ( fg == 1 ) {
                    //mediaPlayer.stop();
                    mediaPlayer.reset();
                    fg = 0;
                    mediaPlayer = mediaPlayer.create(this, R.raw.camila_cabello_havana_song);
                }
                else if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.seekTo(length);
                    fg = 0;
                }

                mediaPlayer.start();
                break;
            case R.id.stop:
                toast = Toast.makeText(getApplicationContext(),
                        " Music stoped ", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
                fg = 1;
                mediaPlayer.stop();
                break;
            case R.id.pause:
                toast = Toast.makeText(getApplicationContext(),
                        " Music Paused ", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
                length = mediaPlayer.getCurrentPosition();
                fg = 0;
                mediaPlayer.pause();
                break;
            default:
                break;
        }
        setTitle("Music Player App");
    }
}