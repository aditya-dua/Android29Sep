package com.adityadua.webservicesdemo29s;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.adityadua.webservicesdemo29s.adaptor.DataAdaptor;
import com.adityadua.webservicesdemo29s.model.DataHandler;
import com.adityadua.webservicesdemo29s.network.CallAddr;
import com.adityadua.webservicesdemo29s.network.NetworkStatus;
import com.adityadua.webservicesdemo29s.network.OnWebServiceResult;
import com.adityadua.webservicesdemo29s.utils.CommonUtilities;
import com.squareup.okhttp.FormEncodingBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnWebServiceResult{

    String url="http://api.themoviedb.org/3/movie/tt0816692/credits?api_key=8496be0b2149805afa458ab8ec27560c";
    List<DataHandler> model = new ArrayList<>();
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        FormEncodingBuilder params = new FormEncodingBuilder();
        params.add("page","1");
        if(NetworkStatus.getInstance(this).isOnline(this)){
            CallAddr call = new CallAddr(this,url,params, CommonUtilities.SERVICE_TYPE.GET_DATA,this);
            call.execute();
        }else{
            Toast.makeText(this, "Please try again", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void getWebResponse(String result, CommonUtilities.SERVICE_TYPE type) {

        Log.v("Resposne ::",result);

        try{
            JSONObject obj = new JSONObject(result);

            JSONArray arr = obj.getJSONArray("cast");
            for (int i=0;i<arr.length();i++){

                JSONObject jObj = arr.getJSONObject(i);

                DataHandler data = new DataHandler();
                data.setCast_id(jObj.getInt("cast_id"));
                data.setCharacter(jObj.getString("character"));
                data.setName(jObj.getString("name"));
                data.setOrder(jObj.getInt("order"));

                model.add(data);
            }

            DataAdaptor data = new DataAdaptor(this,model);
            recyclerView.setAdapter(data);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
