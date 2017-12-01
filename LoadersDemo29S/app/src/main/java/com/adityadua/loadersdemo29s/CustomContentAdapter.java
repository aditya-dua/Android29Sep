package com.adityadua.loadersdemo29s;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;

/**
 * Created by AdityaDua on 29/11/17.
 */

public class CustomContentAdapter extends BaseAdapter {

    Cursor cursor;
    Context mContext;
    LayoutInflater inflater;


    public CustomContentAdapter(Cursor cursor, Context mContext) {
        this.cursor = cursor;
        this.mContext = mContext;
        inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return cursor.getCount();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        Holder holder;


        if(cursor.getCount()>position) {
            cursor.move(position);
        }
        if(view==null){

            view = inflater.inflate(R.layout.row,parent,false);
            holder = new Holder();
            holder.tvContactName = (TextView) view.findViewById(R.id.tvContactName);
            holder.tvContactNumber = (TextView) view.findViewById(R.id.tvContactNumber);

            holder.ivContactImage = (ImageView)view.findViewById(R.id.ivContactImage);

            view.setTag(holder);


        }
        else {
            holder = (Holder)view.getTag();
        }

        holder.tvContactNumber.setText(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
        holder.tvContactName.setText(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)));

        //String imageUri = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI));

        try {
          //  Bitmap bitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), Uri.parse(imageUri));

          //  holder.ivContactImage.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    return  view;

    }



    class Holder {

        TextView tvContactName,tvContactNumber;
        ImageView ivContactImage;


    }
}
