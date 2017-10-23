package com.adityadua.eventhandlingdemosession4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    // event handling

    /** steps for Event Handling
     *
     *  1. Make the object of View
     *  2. Type the XML view to Java
     *  3. For this view set the OnClickListener
     *      setOnClickListener(OnClickListener)
     *      OnClickListener : This is an Interface which os provideod in the
     *      Android Library
     *      This interface has an abstract method :
     *      public void onClick(View v);
     *
     *      Since , OnClickListener is an INTERFACE ::
     *      So to give the funcationlity to onClick ::::
     *      You will need to override this method

     *
     *
     */

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button);
        tv = (TextView)findViewById(R.id.textView);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When a methodis striked out , it means that its deprecated
                // the maker of the app / framework recommds you not to use
                // as it might be removed in the further versions

                // Date form string has been deprecated in Java

                tv.setText("New Text");
                tv.setTextColor(getResources().getColor(R.color.purple));
            }
        });
        // FIrst way to make a OnClickListener :: Anonymous Inner Class Declaration
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "The Button is Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void loginButton(View v){
        Toast.makeText(this, "Login Success !", Toast.LENGTH_SHORT).show();
    }

    public void printName(View v){
        EditText edt = (EditText)findViewById(R.id.editText);
        String name = edt.getText().toString();
        tv.setText(name);
        Toast.makeText(this, "User Pressed the print Buttin with NAme"+name, Toast.LENGTH_SHORT).show();

    }
}
