package com.adityadua.activitydemosession3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        ImageView img = (ImageView)findViewById(R.id.imageView);

        // this textview :: textView is of type XML
        // now we have to convert it to >>>>>>> Java

        textView = (TextView)findViewById(R.id.textView);
        String text = textView.getText().toString();

        textView.setBackgroundResource(R.drawable.acadgild_logo);

        Toast.makeText(getApplicationContext(),"In onCreate() "+text,Toast.LENGTH_LONG).show();


    }

    @Override
    protected void onStart() {
        super.onStart();

        textView.setText("in onStart()");
        Toast.makeText(getApplicationContext(),"In onStart()",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String id = savedInstanceState.getString("contact_id");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"In onResume()",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(),"In onRestart()",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"In onPause()",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"In onStop()",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("contact_id","123");
    }
}
