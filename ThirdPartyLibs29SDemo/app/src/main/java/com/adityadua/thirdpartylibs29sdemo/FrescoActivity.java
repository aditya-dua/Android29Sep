package com.adityadua.thirdpartylibs29sdemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by AdityaDua on 28/11/17.
 */

public class FrescoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fresco.initialize(this);
        setContentView(R.layout.fresco_ui);
        Uri imageUri = Uri.parse("https://i.imgur.com/tGbaZCY.jpg");

        SimpleDraweeView simpleDraweeView = (SimpleDraweeView)findViewById(R.id.sdvImage);

        simpleDraweeView.setImageURI(imageUri);

    }
}
