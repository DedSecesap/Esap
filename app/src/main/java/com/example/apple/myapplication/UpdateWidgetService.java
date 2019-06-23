package com.example.apple.myapplication;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.Random;

public class UpdateWidgetService extends Service {
    private static final String LOG = "de.vogella.android.widget.example";

    @Override
    public void onStart(Intent intent, int startId) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this
                .getApplicationContext());

        int[] allWidgetIds = intent
                .getIntArrayExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS);

//      ComponentName thisWidget = new ComponentName(getApplicationContext(),
//              MyWidgetProvider.class);
//      int[] allWidgetIds2 = appWidgetManager.getAppWidgetIds(thisWidget);
        for (int widgetId : allWidgetIds) {
            // create some random data
            int number = (new Random().nextInt(100));

            RemoteViews remoteViews = new RemoteViews(this
                    .getApplicationContext().getPackageName(),
                    R.layout.activity_widget);
            Log.w("WidgetExample", String.valueOf(number));
            // Set the text
            remoteViews.setTextViewText(R.id.update,
                    "Random: " + String.valueOf(number));

            // Register an onClickListener
            Intent clickIntent = new Intent(this.getApplicationContext(),
                    MyWidgetProvider.class);

            clickIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            clickIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,
                    allWidgetIds);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(
                    getApplicationContext(), 0, clickIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT);
            remoteViews.setOnClickPendingIntent(R.id.update, pendingIntent);
            appWidgetManager.updateAppWidget(widgetId, remoteViews);
        }
        stopSelf();

        super.onStart(intent, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

