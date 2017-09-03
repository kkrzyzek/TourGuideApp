package com.example.android.tourguide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by user on 2017-08-31.
 */

public class FixedTabsPagerAdapter extends FragmentPagerAdapter {

    public FixedTabsPagerAdapter (FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new WawelFragment();
            case 1:
                return new MariackiFragment();
            case 2:
                return new MuseumFragment();
            case 3:
                return new MoundFragment();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position) {
            case 0:
                return "Wawel";
            case 1:
                return "Mariacki Church";
            case 2:
                return "National Museum";
            case 3:
                return "Mound";
            default:
                return null;
        }
    }
}
