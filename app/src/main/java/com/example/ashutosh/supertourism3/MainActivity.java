package com.example.ashutosh.supertourism3;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

//import com.example.ashutosh.supertourism3.fragments.TopTourPlaceFragment;
import com.example.ashutosh.supertourism3.fragments.TourTypeFragment;
//import com.example.ashutosh.supertourism3.fragments.TourismTypeFragment;

import com.example.ashutosh.supertourism3.fragments.TopPlaceFragment;


public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeScreen();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Super Tourism");
       // toolbar.setSubtitle("Subtitle here");

       // toolbar.setLogo(android.R.drawable.btn_star_big_on); // Logo Image
       // toolbar.setNavigationIcon(android.R.drawable.ic_media_previous); // Navigation icon image

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(10f);
        }

    }

    private void initializeScreen() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);

        setSupportActionBar(toolbar);

        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        pager.setOffscreenPageLimit(2);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
    }

    private class SectionPagerAdapter extends FragmentStatePagerAdapter {
        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new TourTypeFragment();
                case 1:
                    return new TopPlaceFragment();

                default:
                    return new TourTypeFragment();
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Tourism Type";
                case 1:
                    return "Top Places";
                default:
                    return "First";
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

    }
}
