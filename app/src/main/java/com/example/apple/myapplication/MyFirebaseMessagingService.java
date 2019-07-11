package com.example.apple.myapplication;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {

    private static final String TAG = "Android News App";
    private static final String CHANNEL_ID = "channel1";
    private static final String FRIENDLY_ENGAGE_TOPIC = "friendly_engage";


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        //It is optional
        Log.e(TAG, "From: " + remoteMessage.getFrom());
        Log.e(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());
        Log.d(TAG, "FCM Message Id: " + remoteMessage.getMessageId());
        Log.d(TAG, "FCM Notification Message: " + remoteMessage.getNotification());
        Log.d(TAG, "FCM Data Message: " + remoteMessage.getData());

        //Calling method to generate notification
        sendNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
    }

    //This method is only generating push notification
    private void sendNotification(String title, String messageBody) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, notificationBuilder.build());
    }



    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);

        Log.d(TAG, "FCM Token: " + token);
        // Once a token is generated, we subscribe to topic.
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser!=null) {
            String email = firebaseUser.getEmail();

            FirebaseMessaging.getInstance()
                    .subscribeToTopic(FRIENDLY_ENGAGE_TOPIC);

            FirebaseMessaging.getInstance()
                    .subscribeToTopic(email.substring(email.indexOf("@") - 5, email.indexOf("@")));

            FirebaseMessaging.getInstance()
                    .subscribeToTopic(email.substring(email.indexOf("@") - 5, email.indexOf("@") - 2));

            FirebaseMessaging.getInstance()
                    .subscribeToTopic(email.substring(email.indexOf("@") - 2, email.indexOf("@")));

            FirebaseMessaging.getInstance()
                    .subscribeToTopic("All");

            FirebaseMessaging.getInstance()
                    .subscribeToTopic("Lost");

            FirebaseMessaging.getInstance()
                    .subscribeToTopic("Found");
        }

    }

    private void sendRegistrationToServer(String token) {


    }

}