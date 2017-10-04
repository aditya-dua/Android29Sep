package com.adityadua.helloworldapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


//My src will have my UI/ front end and the corosponding code
//for it

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
    }
}
