package com.memorylayers.ml.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.memorylayers.ml.view.activity.HomeActivity;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;

import java.util.Collection;

/**
 * Created by ahmed.marzouk on 4/16/2016.
 */

public class LoginController {

    public void loginOrSignUpWithFacebook(final Context ctx, final Activity currentActivity, Collection<String> readPermissions){

        ParseFacebookUtils.logInWithReadPermissionsInBackground(currentActivity,  readPermissions, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (user == null) {
                    Log.d("FbLogin", "The user cancelled the Facebook login.");
                } else if (user.isNew()) {
                    Log.d("FbLogin", "User signed up and logged in through Facebook!");
                    try
                    {
                        Intent k = new Intent(currentActivity, HomeActivity.class);
                        ctx.startActivity(k);
                    }catch(Exception ex){

                    }
                } else {
                    Log.d("FbLogin", "User logged in through Facebook!");
                    try
                    {
                        Intent k = new Intent(currentActivity, HomeActivity.class);
                        ctx.startActivity(k);
                    }catch(Exception ex){

                    }
                }
            }
        });

    }

    public void loginAsDefault(String userName, String password){

        ParseUser.logInInBackground(userName, password , new LogInCallback() {
            public void done(ParseUser user, ParseException e) {
                if (user != null) {
                    //  The user is logged in.
                } else {
                    // Signup failed. Look at the ParseException to see what happened.
                }
            }
        });
    }


}
