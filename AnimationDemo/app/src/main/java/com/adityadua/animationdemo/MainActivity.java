package com.adityadua.animationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button startAnim;
    TextView text;
    ProgressBar progress;
    private  final String CLASS_NAME="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

         final String METHOD_NAME="onCreate";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(METHOD_NAME+"Started","Method Execution has Started");
        text = (TextView)findViewById(R.id.textView);
        startAnim = (Button)findViewById(R.id.button);
        progress = (ProgressBar)findViewById(R.id.progressBar);

        startAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(METHOD_NAME+"Started","On Click Method Called");

                text.setVisibility(TextView.VISIBLE);

                Animation fadeInAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim);
                text.startAnimation(fadeInAnimation);

                fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Log.i("Animation Listener","Started");

                        progress.setVisibility(ProgressBar.VISIBLE);
                        progress.setProgress(50);
                       /* try {
                            //updateProgress();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }*/
                        Toast.makeText(MainActivity.this, "Animation Started", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        progress.setVisibility(ProgressBar.INVISIBLE);
                        Toast.makeText(MainActivity.this, "Animation Stopped / Ended", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        Toast.makeText(MainActivity.this, "Animation On Repeat", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });



    }

    private void updateProgress() throws InterruptedException {
        for(int i=0;i<10;i++) {
            progress.setProgress(i * 10);
            Thread.sleep(1000);
        }
    }
}
