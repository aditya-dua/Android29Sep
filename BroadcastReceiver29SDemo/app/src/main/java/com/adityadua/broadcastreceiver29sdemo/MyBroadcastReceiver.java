package com.adityadua.broadcastreceiver29sdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.widget.Toast;

/**
 * Created by AdityaDua on 20/11/17.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        Toast.makeText(context, "Broadcast Receiver Called"+action, Toast.LENGTH_SHORT).show();

        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(context.getApplicationContext())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Time Changed")
                .setContentText("Actions :"+action)
                .setAutoCancel(false);

        Intent resultIntent = new Intent(context,MainActivity.class);


        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context.getApplicationContext());
        stackBuilder.addParentStack(MainActivity.class);

        stackBuilder.addNextIntent(resultIntent);
        PendingIntent PI= PendingIntent.getActivity(context,0,resultIntent,0);

        mBuilder.setContentIntent(PI);

        NotificationManager nm = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(100,mBuilder.build());


        /*
        Another type of Notification
         */


    }
}
