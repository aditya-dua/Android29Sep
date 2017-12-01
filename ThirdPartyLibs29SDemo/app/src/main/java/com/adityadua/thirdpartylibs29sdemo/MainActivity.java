package com.adityadua.thirdpartylibs29sdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class MainActivity extends AppCompatActivity {


    ImageView imgView;

    String imgURL =  "http://vignette4.wikia.nocookie.net/kungfupanda/images/7/7b/Lei-lei.jpg/revision/latest?cb=20151104195038";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = (ImageView)findViewById(R.id.imageView);


        Glide.with(this)
                .load(imgURL)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgView);

        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,FrescoActivity.class);
                startActivity(i);
            }
        });
    }
}
