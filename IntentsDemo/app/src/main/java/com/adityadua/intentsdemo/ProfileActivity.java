package com.adityadua.intentsdemo;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by AdityaDua on 18/10/17.
 */

public class ProfileActivity extends AppCompatActivity {

    TextView tv1;
    // So the next task is to take a picture form Camera ??

    // Intent : Implict & Explict
    // Implict Intents : These are the intents which are already predefined ::
    // Intent to open dailer => to call a number
    // Explict Intents : These are those intents which we define
    // it means we give the target which is to opened up
    // Intent can be used to start Android Componenets  : Activity OR Service

    // We have a method : startActivity(Intent) => This method id used along with
    // intent and  in the Intent you can pass paramssss
    // startService

    // But now there be might be scenreos wehn we might having a return
    // will use Intents ::
    // but it will have callback to the current class////
    // startActivityforResult(request , intent , response )

    Button cameraBtn,galleryBtn;
    ImageView iv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        Intent i = getIntent();
        String userName = i.getStringExtra("userName");
        Log.d("UserName ",userName);
        tv1 = (TextView)findViewById(R.id.textView5);
        tv1.setText("Hi "+userName+",");
        Toast.makeText(this, "UserName set to TV", Toast.LENGTH_SHORT).show();

        cameraBtn = (Button)findViewById(R.id.button2);
        iv = (ImageView)findViewById(R.id.imageView);
        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ACTION_IMAGE_CAPTURE => Capturing
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePicture,100);

            }
        });

        galleryBtn = (Button)findViewById(R.id.button3);
        galleryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,200);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                Bundle extra = data.getExtras();
                Bitmap imageBMP = (Bitmap) extra.get("data");
                iv.setImageBitmap(imageBMP);
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "User Operation Cancelled", Toast.LENGTH_SHORT).show();
            }
        }
        else if(requestCode == 200){
            if(resultCode == RESULT_OK){
                Uri selectedImage = data.getData();
                String[] filePathcolumn = {MediaStore.Images.Media.DATA};

                Cursor cursor = getContentResolver().query(selectedImage,filePathcolumn,null,null,null);
                cursor.moveToFirst();
                int coulmnIndex = cursor.getColumnIndex(filePathcolumn[0]);
                String picturePath = cursor.getString(coulmnIndex);
                cursor.close();
                iv.setImageBitmap(BitmapFactory.decodeFile(picturePath));

            }else if(resultCode == RESULT_CANCELED){
                Toast.makeText(this, "User Operation Cancelled", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
