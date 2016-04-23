package com.memorylayers.ml.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.memorylayers.ml.R;
import com.memorylayers.ml.controller.HomeController;
import com.memorylayers.ml.view.activity.LoginActivity;
import com.parse.ParseUser;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeProfileFragment extends Fragment {

    // Initialize the controller
    HomeController controller = new HomeController();

    // UI Refrances
    Button btnSignout;
    TextView txtViewWelcomeUser;


    public HomeProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_home_profile, container, false);


        // Inialize UI
        btnSignout = (Button)  rootView.findViewById(R.id.btn_profile_signout);
        txtViewWelcomeUser = (TextView)  rootView.findViewById(R.id.txtview_profile_welcomeuser);
        // Get User Info

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            // do stuff with the user
            txtViewWelcomeUser.setText("Welcome, " + currentUser.getUsername());
        } else {
            // show the signup or login screen
        }


        // onClick
        btnSignout.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                controller.signOut();

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);


            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

}
