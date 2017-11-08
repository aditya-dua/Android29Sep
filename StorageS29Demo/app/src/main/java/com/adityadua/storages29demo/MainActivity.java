package com.adityadua.storages29demo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btn,btn2;
    EditText edt;
    File file;

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// use to create a new file
        file = new File(this.getFilesDir(),"testfile");
        try {
            File file2 =    File.createTempFile("abc","def",this.getCacheDir());
        } catch (IOException e) {
            e.printStackTrace();
        }
        btn = (Button)findViewById(R.id.button);
        edt = (EditText)findViewById(R.id.editText);
        tv = (TextView) findViewById(R.id.textView2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               try {
                   String fileName="testfile";
                   FileOutputStream fileOutputStream = openFileOutput(fileName,Context.MODE_PRIVATE);
                   String text= edt.getText().toString();

                   fileOutputStream.write(text.getBytes());
                   fileOutputStream.close();
                   Toast.makeText(MainActivity.this, "Saving Complete", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        btn2=(Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fin = openFileInput("testfile");
                    String test = String.valueOf(fin.read());

                    fin.close();
                    tv.setText(test);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
