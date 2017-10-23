package com.adityadua.eventhandlingdemosession4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by AdityaDua on 09/10/17.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Button clrBtn,loginBtn;
    EditText userEdt,pwdEdt;
    TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        loginBtn = (Button)findViewById(R.id.button3);
        loginBtn.setOnClickListener(this);

        clrBtn = (Button)findViewById(R.id.button4);
        clrBtn.setOnClickListener(this);

        userEdt = (EditText)findViewById(R.id.editText2);
        pwdEdt = (EditText)findViewById(R.id.editText3);


        tv = (TextView) findViewById(R.id.textView4);
    }

    @Override
    public void onClick(View v) {
        //v.getId();

        if(v.getId() == R.id.button3) {
            String userName = userEdt.getText().toString();
            String pwd = pwdEdt.getText().toString();

            if (userName.equalsIgnoreCase("aditya") && pwd.equals("Aditya")) {
                tv.setText("Login Success For ::" + userName);
            }else{
                tv.setText("Login Failure ");
            }
        }else if(v.getId() == R.id.button4){
            userEdt.setText("");
            pwdEdt.setText("");
            tv.setText("");
        }
    }
}
