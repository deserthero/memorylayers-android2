package com.memorylayers.ml.controller;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

/**
 * Created by ahmed.marzouk on 4/16/2016.
 */
public class ResetPassController {

    public static void resetUserPassword(){

        ParseUser.requestPasswordResetInBackground("ahmed.marzouk@outlook.com", new RequestPasswordResetCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // An email was successfully sent with reset instructions.

                } else {
                    // Something went wrong. Look at the ParseException to see what's up.
                }
            }
        });
    }
}
