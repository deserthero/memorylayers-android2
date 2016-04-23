package com.memorylayers.ml;

import android.app.Application;
import android.util.Log;

import com.facebook.FacebookSdk;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.Date;

/**
 * Created by ahmed.marzouk on 4/15/2016.
 */
public class MLApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        // Parse

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        //in your application class

        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("me57iy345gwala6yl")
                .clientKey(null)
                .server("https://memorylayers.herokuapp.com/parse/")
                .build());


        // Initialize ParseFacebookSDK
        ParseFacebookUtils.initialize(getApplicationContext());

        // Initialize Facebook SDK
        FacebookSdk.sdkInitialize(getApplicationContext());

        // Test Object
        /*
                ParseObject memoryObject = new ParseObject("Memory");
        memoryObject.put("memoryTitle", "The First Saved Object to backend");
        memoryObject.put("memoryStory", "The First Saved Object to backend its a great step to the future");
        memoryObject.put("memoryDate", "15/4/2016");
        memoryObject.saveInBackground(new SaveCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    Log.i("Parse", "Save Succeeded");
                } else {
                    Log.i(e.toString() + "Parse", "Save Failed");
                }
            }
        });
         */



        // ParseUser.enableAutomaticUser();
         ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
           defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);


    }
}
