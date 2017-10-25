package com.adityadua.listdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    String[] languages = {"Java","C++","JavaScript","Kotlin"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.list);

        ArrayAdapter<String> mAdaptor = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,languages);

        lv.setAdapter(mAdaptor);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You have clicked element:"+languages[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
