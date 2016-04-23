package com.memorylayers.ml.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.memorylayers.ml.model.User;
import com.memorylayers.ml.view.activity.LoginActivity;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Created by ahmed.marzouk on 4/16/2016.
 */

public class SignupController {



    public void signUpAsDefault(User newUser, final Context context){

        final boolean isUserCreated;

        ParseUser newParseUser = new ParseUser();

            newParseUser.setEmail(newUser.getEmail());
            newParseUser.setUsername(newUser.getUserName());
            newParseUser.setPassword(newUser.getPassword());
            // newParseUser.put("fullName", newUser.getFullName());
            //  newParseUser.put("birthDate", newUser.getBirthDate());


        newParseUser.signUpInBackground(new SignUpCallback(){

            @Override
            public void done(ParseException e) {

                if (e == null)
                {
                  // New User Created
                    Toast.makeText(context,"User Created!",Toast.LENGTH_LONG);

                    try
                    {
                        Intent k = new Intent((Activity) context, LoginActivity.class);
                        context.startActivity(k);
                    }catch(Exception ex){

                    }

                } else
                {
                    // Error log it
                    Toast.makeText(context,e.toString(),Toast.LENGTH_LONG);
                }
            }
        });



    }
}
