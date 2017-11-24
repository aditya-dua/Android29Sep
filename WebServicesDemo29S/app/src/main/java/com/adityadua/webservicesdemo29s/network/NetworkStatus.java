package com.adityadua.webservicesdemo29s.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by AdityaDua on 22/11/17.
 */

public class NetworkStatus {

    private static NetworkStatus instance = new NetworkStatus();
    static Context context;
    ConnectivityManager connectivityManager;
    boolean connected= false;


    public static NetworkStatus getInstance(Context con){
        context = con;
        return  instance;

    }

    public boolean isOnline(Context con){

        try {
            connectivityManager = (ConnectivityManager) con.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            connected = networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
            return connected;
        }catch (Exception e){
            e.printStackTrace();

            Toast.makeText(con, "Check Network Connection::"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return  connected;

    }
}
