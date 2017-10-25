package com.adityadua.menudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    ArrayList<String> contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tb = (Toolbar)findViewById(R.id.toolbar);
        tb.setSubtitle("Sub Title");
        tb.setTitle("Title");
        tb.setNavigationIcon(R.mipmap.ic_launcher);
        getSupportActionBar();
        contact = new ArrayList<>();
        for(int i =0 ;i<=10;i++){
            contact.add(i,"Item ::"+i);
        }
        ArrayAdapter<String> adaptor = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contact);
        list = (ListView)findViewById(R.id.list);
        list.setAdapter(adaptor);
        registerForContextMenu(list);
        TextView tv = (TextView)findViewById(R.id.textView2);
        registerForContextMenu(tv);
       // registerForContextMenu();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Context Menu Exmaple");
        menu.setHeaderIcon(R.mipmap.ic_launcher);

        if(v.getId() == R.id.list) {
            menu.add(0, 100, 1, "Context Menu 1");
            menu.add(0, 101, 2, "Context Menu 2");
            menu.add(0, 102, 3, "Context Menu 3");
            menu.add(0, 103, 5, "Context Menu 4");
            menu.add(0, 104, 4, "Context Menu 5");
        }
        else if(v.getId() == R.id.textView2){
            menu.add(1, 100, 1, "Context Menu 1");
            menu.add(1, 101, 2, "Context Menu 2");
            menu.add(1, 102, 3, "Context Menu 3");

        }



    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        

        if(item.getItemId() == 100 ){
            Toast.makeText(this, "Item is clicked : Context Menu 1", Toast.LENGTH_SHORT).show();
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater Menu = getMenuInflater();
        Menu.inflate(R.menu.main,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       //
        int menuId = item.getItemId();

        if(menuId == R.id.save){
            Toast.makeText(this, "Data Saved !!", Toast.LENGTH_SHORT).show();
        }
        else if(menuId == R.id.Refresh){
            Toast.makeText(this,"Data Refreshed!!",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);

    }
}
