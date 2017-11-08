package com.adityadua.widgetsdemos29;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RemoteViews;
import android.widget.Toast;

public class MainActivity extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        for(int i=0;i<appWidgetIds.length;i++){
            int currentId = appWidgetIds[i];

            String url ="http://www.acadgild.com";

            /*Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse(url));
*/

            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            intent.setData(Uri.parse("tel:1234567890"));
            PendingIntent pi = PendingIntent.getActivity(context,0,intent,0);
            RemoteViews view = new RemoteViews
                    (context.getPackageName(),R.layout.activity_main);
            view.setOnClickPendingIntent(R.id.button,pi);
            appWidgetManager.updateAppWidget(currentId,view);
            Toast.makeText(context, "Widget has been added", Toast.LENGTH_SHORT).show();
        }
    }
}
