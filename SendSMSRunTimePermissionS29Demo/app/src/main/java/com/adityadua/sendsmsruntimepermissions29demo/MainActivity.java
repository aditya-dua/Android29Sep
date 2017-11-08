package com.adityadua.sendsmsruntimepermissions29demo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button sendBtn;
    EditText phoneEdt,msgEdt;
    TextView statusTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = (Button)findViewById(R.id.button);
        phoneEdt = (EditText)findViewById(R.id.editText);
        msgEdt = (EditText)findViewById(R.id.editText2);

        statusTV = (TextView)findViewById(R.id.statusTV);


        sendBtn.setOnClickListener(this);
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Permission is not granted", Toast.LENGTH_SHORT).show();

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},123);
            sendBtn.setEnabled(false);
        }else{
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            sendBtn.setEnabled(true);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 123){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                statusTV.setText("Permission Granted Good to Continue or Send SMS");
                sendBtn.setEnabled(true);
            }else{
                statusTV.setText("Permission Not Granted");
                sendBtn.setEnabled(false);
            }
        }

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.button) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneEdt.getText().toString(), null, msgEdt.getText().toString(), null, null);
            statusTV.setText("Message Sent Successfully");
        }


    }
}
