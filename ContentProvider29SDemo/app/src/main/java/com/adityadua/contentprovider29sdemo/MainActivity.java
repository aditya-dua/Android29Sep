package com.adityadua.contentprovider29sdemo;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    TextView textview;
    SMSContentObserver contentObserver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textview = (TextView)findViewById(R.id.textView);


        contentObserver = new SMSContentObserver(this,handler);

        Uri uri = Uri.parse("content://sms/inbox");
        getContentResolver().registerContentObserver(uri,true,contentObserver);

    }

    Handler handler  = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            String str = (String)msg.obj;
            textview.setText(str);
            String testStr= str.substring(str.indexOf("Message:"),str.length());
            Toast.makeText(MainActivity.this, "test Str is::"+testStr, Toast.LENGTH_SHORT).show();
            String otp = fetchOTP(testStr);

            textview.setText(otp);
        }
    };

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
