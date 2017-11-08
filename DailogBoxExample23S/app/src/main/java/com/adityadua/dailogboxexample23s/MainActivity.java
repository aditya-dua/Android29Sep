package com.adityadua.dailogboxexample23s;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static  int i=0,sti=0;
    RelativeLayout rel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rel = (RelativeLayout)findViewById(R.id.activity_main);
        rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(i!=0){
                   i=0;
               }
            }
        });

        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i!=0){
                    i=0;
                }
                openExitDailog();
            }
        });

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if(i==0){
            i++;
            CounterThread c = new CounterThread();
            c.start();


            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
        }else{
            openExitDailog();
            i=0;
        }

    }

    private void openExitDailog(){

        AlertDialog.Builder alertDailogBuilder =new AlertDialog.Builder(MainActivity.this);
        alertDailogBuilder.setTitle("Exit The App !");
        alertDailogBuilder.setMessage("Are you sure you want to exit ?");

        alertDailogBuilder.setIcon(R.mipmap.ic_launcher);
        alertDailogBuilder.setPositiveButton("Exit !", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Exiting the app", Toast.LENGTH_SHORT).show();
               finish();
            }
        });

        alertDailogBuilder.setNegativeButton("Stay Here !", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "I am here to make you dont Exit Accidently", Toast.LENGTH_SHORT).show();
               dialog.cancel();
            }
        });

        alertDailogBuilder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Some other activty can be opened
            }
        });

        AlertDialog alertDailog = alertDailogBuilder.create();
        alertDailog.show();

    }

    public class CounterThread extends Thread{

        @Override
        public void run() {
            super.run();

            try {
                this.sleep(10000);
                if(MainActivity.i != 0){
                    i=0;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
