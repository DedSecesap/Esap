package com.example.apple.myapplication;

import android.util.Log;

import static android.support.constraint.Constraints.TAG;

public class MyFcmListenerService {


    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is also called
     * when the Instance ID token is initially generated, so this is where
     * you retrieve the token.
     */
    // [START refresh_token]
    
    public void onNewToken(String token) {
        Log.d(TAG, "New token: " + token);
        // TODO: Implement this method to send any registration to your app's servers.
        sendRegistrationToServer(token);
    }

    public void sendRegistrationToServer(String token) {
    }

}
