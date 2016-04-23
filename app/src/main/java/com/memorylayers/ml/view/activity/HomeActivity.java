package com.memorylayers.ml.view.activity;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.memorylayers.ml.R;
import com.memorylayers.ml.adapter.ViewPagerAdapter;
import com.memorylayers.ml.view.fragment.HomeMemoryMapFragment;

public class HomeActivity extends AppCompatActivity implements HomeMemoryMapFragment.OnFragmentInteractionListener {

    //Declaring All The Needed Variables
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize UI
        tabLayout = (TabLayout) findViewById(R.id.tablayout_home);
        viewPager = (ViewPager) findViewById(R.id.viewpager_home);


        // Creating Adapter and setting that adapter to the viewPager
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

         /*
        TabLayout.newTab() method creates a tab view, Now a Tab view is not the view
        which is below the tabs, its the tab itself.
         */
        final TabLayout.Tab timelineTab = tabLayout.newTab();
        final TabLayout.Tab addMemoryTab = tabLayout.newTab();
        final TabLayout.Tab profileTab = tabLayout.newTab();
        final TabLayout.Tab memoriesMapTab = tabLayout.newTab();

        //Setting Icons to our respective tabs
        timelineTab.setIcon(R.mipmap.timelineblack32);
        addMemoryTab.setIcon(R.mipmap.addmcolored32);
        memoriesMapTab.setIcon(R.mipmap.monmapblack32);
        profileTab.setIcon(R.mipmap.profileblack32);

        /*
        Adding the tab view to our tablayout at appropriate positions
        As I want home at first position I am passing home and 0 as argument to
        the tablayout and like wise for other tabs as well
         */
        tabLayout.addTab(timelineTab, 0);
        tabLayout.addTab(addMemoryTab, 1);
        tabLayout.addTab(memoriesMapTab, 2);
        tabLayout.addTab(profileTab, 3);

         /*
        TabTextColor sets the color for the title of the tabs, passing a ColorStateList here makes
        tab change colors in different situations such as selected, active, inactive etc
        TabIndicatorColor sets the color for the indiactor below the tabs
         */

        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this, R.color.tab_selector));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.indicator));

        /*
        Adding a onPageChangeListener to the viewPager
        1st we add the PageChangeListener and pass a TabLayoutPageChangeListener so that Tabs Selection
        changes when a viewpager page changes.

        2nd We add the onPageChangeListener to change the icon when the page changes in the view Pager
         */

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        /*
                        setting Home as White and rest grey
                        and like wise for all other positions
                         */
                      //  home.setIcon(R.drawable.ic_home_white);
                      //  inbox.setIcon(R.drawable.ic_inbox_grey);
                      //     star.setIcon(R.drawable.ic_star_grey);
                        break;
                    case 1:
                      //  home.setIcon(R.drawable.ic_home_grey);
                     // inbox.setIcon(R.drawable.ic_inbox_white);
                     // star.setIcon(R.drawable.ic_star_grey);
                        break;
                    case 2:
                      // home.setIcon(R.drawable.ic_home_grey);
                      // inbox.setIcon(R.drawable.ic_inbox_grey);
                      // star.setIcon(R.drawable.ic_star_white);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
