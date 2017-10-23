package com.adityadua.calculatordemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn0,btn1,btn2,btn3,btnAdd,btnEqual;
    TextView textDisplay;
    int op1,op2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn0 = (Button)findViewById(R.id.btn10);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnEqual = (Button)findViewById(R.id.btnEqual);

        textDisplay = (TextView)findViewById(R.id.txtCalcDisplay);


        btnEqual.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1 :

                if(textDisplay.getText().toString().equals("0")){
                    textDisplay.setText("1");
                }else{
                    textDisplay.setText(textDisplay.getText().toString()+"1");
                }
                    break;

            case R.id.btn2 :

                if(textDisplay.getText().toString().equals("0")){
                    textDisplay.setText("2");
                }else{
                    textDisplay.setText(textDisplay.getText().toString()+"2");
                }
                break;

            case R.id.btn3 :

                if(textDisplay.getText().toString().equals("0")){
                    textDisplay.setText("3");
                }else{
                    textDisplay.setText(textDisplay.getText().toString()+"3");
                }
                break;

            case R.id.btnAdd :
                String textCurrent = textDisplay.getText().toString();


                if(textCurrent.equals("0")){
                    op1= 0;

                }else if(!textCurrent.equals("0")){
                    op1= Integer.parseInt(textCurrent);
                }
                textDisplay.setText("0");
                break;

            case R.id.btnEqual :
                String textCurrent2 = textDisplay.getText().toString();
                int sum;

                if(textCurrent2.equals("0")){
                    op2= 0;

                }else if(!textCurrent2.equals("0")){
                    op2= Integer.parseInt(textCurrent2);
                }
                sum = op1+op2;

                textDisplay.setText(Integer.toString(sum));
                break;


        }

    }
}
