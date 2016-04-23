package com.memorylayers.ml.helper;

import android.text.TextUtils;

/**
 * Created by ahmed.marzouk on 4/16/2016.
 */
public class LoginHelper {

    // Check if usename valid ...
    public static boolean isUsernameValid(String username) {
        return !TextUtils.isEmpty(username) && username.length() >= 6;
    }

    // Check if the mail is valid ...
    public static  boolean isEmailValid(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    // Check if password valid ...
    public static boolean isPasswordValid(String password) {
        return !TextUtils.isEmpty(password) && password.length() >= 6;
    }

}
