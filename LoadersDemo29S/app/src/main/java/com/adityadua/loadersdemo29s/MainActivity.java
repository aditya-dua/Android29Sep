package com.adityadua.loadersdemo29s;

import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    ListView lstContact;

    CustomContentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstContact = (ListView)findViewById(R.id.lstContacts);

        getSupportLoaderManager().initLoader(1,null,this);

    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {


        Uri CONTACT_URI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        CursorLoader cursorLoader = new CursorLoader(this,CONTACT_URI,null,null,null,null);


        return cursorLoader;
    }

    @Override
    public void onLoadFinished(Loader loader, Cursor data) {
        data.moveToFirst();
        adapter = new CustomContentAdapter(data,this);
        lstContact.setAdapter(adapter);


    }

    @Override
    public void onLoaderReset(Loader loader) {

    }
}
