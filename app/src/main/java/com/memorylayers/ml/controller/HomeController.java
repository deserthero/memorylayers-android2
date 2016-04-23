package com.memorylayers.ml.controller;

import com.parse.ParseUser;

/**
 * Created by ahmed.marzouk on 4/16/2016.
 */
public class HomeController {

    public static void signOut(){
        ParseUser.logOut();
        ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
    }
}
