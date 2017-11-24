package com.adityadua.simplethreadexample29s;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button loadIcon,CheckButton;
    ImageView imageView;
    Bitmap bmp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        loadIcon = (Button)findViewById(R.id.button);
        CheckButton = (Button)findViewById(R.id.button2);


        loadIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadImage();
            }
        });
        CheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Running Fine", Toast.LENGTH_SHORT).show();
            }
        });


        // can we do it here ???

    }

    private void loadImage(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(50000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                bmp = BitmapFactory.decodeResource(getResources(),R.drawable.acad_logo);
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bmp);
                    }
                });
            }
        }).start();

    }
}
