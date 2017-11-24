package com.adityadua.broadcastreceiver29sdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bigTextN,bigPicN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bigTextN = (Button) findViewById(R.id.button);
        bigTextN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bigTextNotification();
            }
        });

        bigPicN  = (Button)findViewById(R.id.button2);
        bigPicN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bigPictureNotification();
            }
        });

    }

    public void bigPictureNotification(){

        Bitmap icon = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setAutoCancel(true)
                .setContentTitle("Big Text Notification")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(icon)
                .setContentText("Big Picture Notification Text")
                .addAction(R.mipmap.ic_launcher,"Share",PendingIntent.getActivity(
                        this,0,getIntent(),0))
                .addAction(R.mipmap.ic_launcher,"Reply",PendingIntent.getActivity(
                        this,0,getIntent(),0));


        NotificationCompat.BigPictureStyle bigPictureStyle= new NotificationCompat.BigPictureStyle();

        bigPictureStyle.bigPicture(icon);
        bigPictureStyle.setBigContentTitle("Notification");

        mBuilder.setStyle(bigPictureStyle);

        Intent resultIntent = new Intent(MainActivity.this,SecondActivity.class);


        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(SecondActivity.class);

        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPI = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setContentIntent(resultPI);
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(100,mBuilder.build());

    }

    public void bigTextNotification(){

        Bitmap icon = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Big Text Notifcation")
                .setAutoCancel(true)
                .setLargeIcon(icon);


        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        bigText.bigText("The Nilekanis are the fourth Indians after Wipro chairman Azim Premji, Biocon chairman Kiran Mazumdar-Shaw and Sobha Developers Chairman Emeritus P N C Menon to sign up for The Giving Pledge.");

        bigText.setBigContentTitle("Nilekanis : Donate half of their wealth");
        bigText.setSummaryText("Testing");

        mBuilder.setStyle(bigText);

        Intent resultIntent = new Intent(MainActivity.this,SecondActivity.class);


        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(SecondActivity.class);

        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPI = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setContentIntent(resultPI);
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(100,mBuilder.build());





    }
}
