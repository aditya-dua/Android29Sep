package com.adityadua.registerationformdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by AdityaDua on 25/10/17.
 */

public class RegisterationActivity extends AppCompatActivity implements View.OnClickListener{

    Button register;
    EditText name,phone;
    CheckBox cJavaCB,androidCB,bDataCB,aJavaCB;
    RadioGroup gender;
    String genderStr;
    String age;
    Spinner age_grp;
    String [] age_grp_array ={
            "Select Age Group",
            "10-15",
            "16-18",
            "19-21",
            "22-25",
            "26 & above"
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registeration_form);

        age_grp = (Spinner)findViewById(R.id.age_groupSpn);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,age_grp_array);
        age_grp.setAdapter(adapter);
        age_grp.setPrompt("Age Group");
        age_grp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                age=age_grp_array[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(RegisterationActivity.this, "Nothing Selected", Toast.LENGTH_SHORT).show();
            }
        });

        name = (EditText)findViewById(R.id.name);
        phone = (EditText)findViewById(R.id.phoneNo);
        gender = (RadioGroup)findViewById(R.id.gender_group);

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId== R.id.male){
                    genderStr = "Male";
                }else if(checkedId == R.id.female){
                    genderStr = "Female";
                }

            }
        });
        cJavaCB = (CheckBox)findViewById(R.id.CJavaChckBox);
        aJavaCB = (CheckBox)findViewById(R.id.AJavaChckBox);
        androidCB = (CheckBox)findViewById(R.id.androidChKBox);
        bDataCB = (CheckBox)findViewById(R.id.BigDataChckBox);

        register = (Button)findViewById(R.id.submit);
        register.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.submit){
            String finalRegisstr= "Name :"+name.getText().toString()+"\nPhone Number :"+
                    phone.getText().toString()+"\nGender :"+genderStr+"\nAge Is:"+age;
            if(cJavaCB.isChecked()){
                finalRegisstr = finalRegisstr+"\nCourse Enquired :: Core Java";
            }
            if(aJavaCB.isChecked()){
                finalRegisstr = finalRegisstr+"\nCourse Enquired :: Advanced Java";
            }
            if(androidCB.isChecked()){
                finalRegisstr = finalRegisstr+"\nCourse Enquired :: Android Application Development Using Java";
            }
            if(bDataCB.isChecked()){
                finalRegisstr = finalRegisstr+"\nCourse Enquired :: Big Data ";
            }
            Toast.makeText(this, finalRegisstr, Toast.LENGTH_LONG).show();

        }
    }
}
