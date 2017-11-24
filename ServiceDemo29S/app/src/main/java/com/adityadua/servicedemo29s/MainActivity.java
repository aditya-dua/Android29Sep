package com.adityadua.servicedemo29s;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer mp = MediaPlayer.create(this,R.raw.song);

        Button startSong = (Button) findViewById(R.id.button);
        startSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //mp.start();

                Intent i = new Intent(MainActivity.this,MusicService.class);
                startService(i);
            }
        });

        Button stopSong = (Button)findViewById(R.id.button2);
        stopSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,MusicService.class);
                stopService(i);

            }
        });
    }
}
