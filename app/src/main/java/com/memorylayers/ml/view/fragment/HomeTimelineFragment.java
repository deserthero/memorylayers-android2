package com.memorylayers.ml.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.memorylayers.ml.R;
import com.memorylayers.ml.controller.HomeController;
import com.memorylayers.ml.view.activity.LoginActivity;
import com.memorylayers.ml.view.activity.ResetPassActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTimelineFragment extends Fragment {

    // Initialize the controller
    HomeController controller = new HomeController();





    public HomeTimelineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home_timeline, container, false);



        // Inflate the layout for this fragment
        return rootView;

    }

}
