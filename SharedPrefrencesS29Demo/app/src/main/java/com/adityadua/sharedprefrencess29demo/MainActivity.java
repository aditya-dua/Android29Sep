package com.adityadua.sharedprefrencess29demo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    SharedPreferences sharedPreferences;
    EditText text;
    TextView textView;
    Button save,fetch;

    public static  final String MYPREFRENCES="mypref";
    public static final String KEY ="textKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        text = (EditText) findViewById(R.id.editText);
        save = (Button) findViewById(R.id.button);
        fetch = (Button)findViewById(R.id.button2);
        textView = (TextView)findViewById(R.id.textView2);

        sharedPreferences = getSharedPreferences(MYPREFRENCES, Context.MODE_PRIVATE);

        if(sharedPreferences.contains(KEY)){
            textView.setVisibility(TextView.VISIBLE);
            textView.setText(sharedPreferences.getString(KEY,""));
        }else{
            textView.setText("");
            textView.setVisibility(View.INVISIBLE);
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Save Button Clicked", Toast.LENGTH_SHORT).show();

                String str = text.getText().toString();

                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putString(KEY,str);
                editor.commit();
                Toast.makeText(MainActivity.this, "Saved to SP", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
