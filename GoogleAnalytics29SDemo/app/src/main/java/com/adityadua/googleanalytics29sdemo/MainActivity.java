package com.adityadua.googleanalytics29sdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MainActivity extends AppCompatActivity {

    Tracker mTracker;

    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();

        mButton = (Button)findViewById(R.id.button2);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory("User Registeration")
                        .setAction("Login")
                        .build());

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Trackked", "Setting screen name: " + "MainActivity");
        mTracker.setScreenName("MyApp~" + "Mainactivity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

    }
}
