package com.adityadua.activitydemo29s;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * What is an Activity ?
     * Activity is basically the UI screen that you see....
     * A UI screen is the XMl which is shown to the user...
     * but how does activity works internally
     * how does the system comes to know like which part of activity start first ?
     * are there some predefined functions which are called ?
     *
     *
     * Lifecycle : Each item / thing / person or animal has a lifecycle
     *
     * onCreate method is the first method
     * From the onCreate the flow will go to the onStart method ::
     *
     * onCreate
     * onStart
     * onResume
     * onPause
     * onStop
     * onDestroy
     * onRestart
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abc_def_ghi);

        if(savedInstanceState == null){// first time
             }else {//its reloading
             }
        Toast.makeText(this, "onCreate method called.....", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart Called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume Called", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "on Restart called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "on Pause () called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, "On Stop Called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
