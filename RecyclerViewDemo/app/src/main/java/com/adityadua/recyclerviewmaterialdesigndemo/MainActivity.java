package com.adityadua.recyclerviewmaterialdesigndemo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        String featuresJB = "Enhanced accessibility\n" +
                "Bi-directional text and other language support\n" +
                "User-installable keyboard maps\n" +
                "Expandable notifications\n" +
                "Ability to turn off notifications on an application-specific basis\n" +
                "Shortcuts and widgets can automatically be re-arranged or re-sized to allow new items to fit on home screens";

        String featuresKK = "Refreshed interface with white elements instead of blue\n" +
                "Clock no longer shows bold hours; all digits are thin. The H, M, and S markings for the stopwatch and timer have been removed, leaving just the numbers.\n" +
                "Ability for applications to trigger translucency in the navigation and status bars[147]\n" +
                "Ability for applications to use \"immersive mode\" to keep the navigation and status bars hidden while maintaining user interaction[148]\n" +
                "Action overflow menu buttons are always visible, even on devices with a \"Menu\" key, which was officially deprecated by Android 4.0.[149]\n" +
                "Restriction for applications when accessing external storage, except for their own directories\n" +
                "Optimizations for performance on devices with lower specifications, including zRAM support and \"low RAM\" device API[143]";

        String featuresNG ="Ability to display color calibration\n" +
                "Ability to screen zoom\n" +
                "Ability to switch apps by double tapping in overview button\n" +
                "Added Emergency information part\n" +
                "Added the \"Clear All\" button in Overview screen\n" +
                "Another system partition, which gets updated when not in use, allowing for seamless system updates\n" +
                "Daydream virtual reality platform (VR interface)\n" +
                "Improved Doze functionality, which aims to prolong battery life\n" +
                "Improvements to file browser\n" +
                "More Quick Settings options";

        String featuresO="Picture-in-picture support\n" +
                "Support for Unicode 10.0 emoji (5.0) and replacement of all blob-shaped emojis by round ones with gradient and outline\n" +
                "Redesigned Quick Settings and Settings with white background and respectively black and Accent font color\n" +
                "Restructured Settings by regrouping in sections similar entries\n" +
                "Adaptive icons\n" +
                "Notification improvements\n" +
                "Notification channels\n" +
                "Notification dots (badges)\n" +
                "Notification snoozing\n" +
                "Notification multi-colored backgrounds support (for music album art, messengers etc)\n" +
                "Android Go option, an optional lightweight distribution of Android for low-end devices with less than 1GB RAM (Oreo 8.0 or higher)\n" +
                "System-wide Autofill framework\n" +
                "Sony LDAC codec support\n" +
                "App-specific unknown sources\n" +
                "Multi-display support\n" +
                "2 times faster boot time\n" +
                "Apps background execution and location limits\n" +
                "Google Play Protect\n" +
                "Downloadable fonts\n" +
                "Integrated printing support\n" +
                "Deep color (Wider color gamut for apps)\n" +
                "Wi-Fi Assistant";
        ItemData itemData[] = {

          new ItemData("4.0 : Jelly Beans",featuresJB,R.drawable.jelly_beans),
          new ItemData("4.4 : Kit Kat",featuresKK,R.drawable.kitkat),
          new ItemData("7.0 : Nougat",featuresNG,R.drawable.nougat),
          new ItemData("8.0 : Oreo",featuresO,R.drawable.oreo)

        };

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdaptor myAdaptor = new MyAdaptor(itemData);
        recyclerView.setAdapter(myAdaptor);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,TestActivity.class);
                startActivity(i);
            }
        });


    }
}
