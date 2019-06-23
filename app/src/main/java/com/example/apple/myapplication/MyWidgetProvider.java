package com.example.apple.myapplication;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.Random;



public class MyWidgetProvider extends AppWidgetProvider {
    private static final String ACTION_CLICK = "ACTION_CLICK";
    private static final String LOG = "de.vogella.android.widget.example";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {
        Log.w(LOG,"onUpdate method called");
        // Get all ids

        ComponentName thisWidget = new ComponentName(context,
                MyWidgetProvider.class);
        int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
        // Build the intent to call the service
        Intent updateintent = new Intent(context.getApplicationContext(),
                UpdateWidgetService.class);
        updateintent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, allWidgetIds);

        // Update the widgets via the service
        context.startService(updateintent);
        for (int widgetId : allWidgetIds) {
            // create some random data
            int number = (new Random().nextInt(100));

            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                    R.layout.activity_widget);
            Log.w("WidgetExample", String.valueOf(number));
            // Set the text
            remoteViews.setTextViewText(R.id.update, String.valueOf(number));

            // Register an onClickListener
            Intent intent = new Intent(context, MyWidgetProvider.class);

            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
                    0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            remoteViews.setOnClickPendingIntent(R.id.update, pendingIntent);
            appWidgetManager.updateAppWidget(widgetId, remoteViews);

        }
    }
}



