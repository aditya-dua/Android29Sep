package com.adityadua.intentsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by AdityaDua on 18/10/17.
 */

public class SecondActivity extends AppCompatActivity {

    EditText userName,password;
    Button login;
    TextView forgotPwdLink;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);


        userName = (EditText)findViewById(R.id.usrNameEdt);
        password = (EditText) findViewById(R.id.pwdEdt);

        login = (Button)findViewById(R.id.loginBtn);

        forgotPwdLink=(TextView)findViewById(R.id.textView4);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userStr = userName.getText().toString();
                String passStr = password.getText().toString();
                if(userStr.equalsIgnoreCase("aditya") && passStr.equals("Aditya")){
                    // Login
                    Intent i = new Intent(SecondActivity.this,ProfileActivity.class);
                    // the user name
                    i.putExtra("userName",userStr);
                    startActivity(i);
                }else{
                    Toast.makeText(SecondActivity.this, "Incorrect UserName/Password ! Please reset ", Toast.LENGTH_SHORT).show();
                    // show a textView to take to the Forget Passsword Screen
                    forgotPwdLink.setVisibility(TextView.VISIBLE);
                }
              }
        });

        forgotPwdLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this,ResetPasswordActivity.class);
                startActivity(i);
            }
        });


    }
}
