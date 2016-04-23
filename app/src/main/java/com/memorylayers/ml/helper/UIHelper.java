package com.memorylayers.ml.helper;

import android.graphics.drawable.TransitionDrawable;
import android.util.Log;
import android.view.View;

import com.memorylayers.ml.R;

/**
 * Created by ahmed.marzouk on 4/15/2016.
 */
public class UIHelper {


    public static void startViewBackgroundTransation(View transationView, int transationDuration){
        TransitionDrawable transition = (TransitionDrawable) transationView.getBackground();
        transition.startTransition(transationDuration);
    }
}
