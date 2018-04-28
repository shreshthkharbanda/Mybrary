package com.codegeek.fblalibraryapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;

/**
 * This class is used to communicate with the FireBase database. This
 * class specifically registers each individual user's id with database.
 *
 * @Shreshth Kharbanda
 */
public class FirebaseId extends FirebaseInstanceIdService {
    private static final String TAG = "FirebaseIDService";
    public static final String myPrefs = "myPrefs" ;
    public static final String tokenKey = "tokenKey";
    public static final String registrationKey = "registrationKey";

    SharedPreferences sharedpreferences;

    /**
     * Persist token to third-party servers.
     *
     * Modify this method to associate the user's FCM InstanceID token with any server-side account
     * maintained by your application.
     */
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        sharedpreferences = getSharedPreferences(myPrefs, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(registrationKey, refreshedToken);
        editor.apply();

        FirebaseMessaging.getInstance().subscribeToTopic("booksOverdue");
//        Toast.makeText(getApplicationContext(), refreshedToken, Toast.LENGTH_SHORT).show();

        // TODO: Implement this method to send any registration to your app's servers.
        sendRegistrationToServer(refreshedToken);
    }

    /**
     * Persist token to third-party servers.
     *
     * Modify this method to associate the user's FCM InstanceID token with any server-side account
     * maintained by your application.
     *
     * @param token The new token.
     */
    private void sendRegistrationToServer(String token) {
        // Add custom implementation, as needed.
        Log.d(TAG, "Token: " + token);

        sharedpreferences = getSharedPreferences(myPrefs, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString(tokenKey, token);
        editor.apply();

        Log.v("FirebaseID--SharedPrefs", "Done saving to shared prefs!!");
//        Toast.makeText(getApplicationContext(),"Done saving to shared prefs!!",Toast.LENGTH_LONG).show();
    }
}