package com.memorylayers.ml.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.memorylayers.ml.view.fragment.HomeAddMemoryFragment;
import com.memorylayers.ml.view.fragment.HomeMemoryMapFragment;
import com.memorylayers.ml.view.fragment.HomeProfileFragment;
import com.memorylayers.ml.view.fragment.HomeTimelineFragment;

/**
 * Created by ahmed.marzouk on 4/16/2016.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        // for each position should return the corresponding fragment ..

        switch(position) {

            case 0: return new HomeTimelineFragment();
            case 1: return new HomeAddMemoryFragment();
            case 2: return new HomeMemoryMapFragment();
            case 3: return new HomeProfileFragment();
            default: return new HomeTimelineFragment();
        }

    }

    @Override
    public int getCount() {
        return 4; // 4 tabs
    }
}
