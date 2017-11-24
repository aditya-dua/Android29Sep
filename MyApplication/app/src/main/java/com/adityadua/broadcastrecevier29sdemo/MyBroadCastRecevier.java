package com.adityadua.broadcastrecevier29sdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by AdityaDua on 20/11/17.
 */

public class MyBroadCastRecevier extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Broadcast Receiver Triggered", Toast.LENGTH_SHORT).show();



    }
}
