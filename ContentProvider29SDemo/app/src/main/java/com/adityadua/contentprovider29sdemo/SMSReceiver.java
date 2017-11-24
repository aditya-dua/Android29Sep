package com.adityadua.contentprovider29sdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by AdityaDua on 24/11/17.
 */

public class SMSReceiver extends BroadcastReceiver {
    SMSContentObserver contentObserver;

    @Override
    public void onReceive(final Context context, Intent intent) {

        Uri uri = Uri.parse("content://sms/inbox");

        Cursor cursor = context.getContentResolver().query(uri,null,null,null,"date ASC");

        cursor.moveToLast();
        StringBuilder builder = new StringBuilder();

        builder.append("From:"+cursor.getString(cursor.getColumnIndex("address")));
        builder.append("Message:"+cursor.getString(cursor.getColumnIndex("body")));

        cursor.close();
        String str = builder.toString();

        String testStr= str.substring(str.indexOf("Message:"),str.length());
        Toast.makeText(context, "test Str is::"+testStr, Toast.LENGTH_SHORT).show();
        String otp = fetchOTP(testStr);

        Toast.makeText(context, "OTP is::"+otp, Toast.LENGTH_SHORT).show();

    }



    //Regular Expressions ??

    public static String fetchOTP(String in){

        Pattern p = Pattern.compile("(\\d){6}");
        Matcher m = p.matcher(in);

        if(m.find()){
            return m.group(0);

        }
        return "";

    }
}
