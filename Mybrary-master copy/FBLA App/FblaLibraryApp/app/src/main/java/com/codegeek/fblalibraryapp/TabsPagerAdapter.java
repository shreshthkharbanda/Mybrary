package com.codegeek.fblalibraryapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by shreshthkharbanda for FblaLibraryApp.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter{
    TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {
        // each individual tab
        switch (index) {
            case 0:
                return new BookDatabaseFragment();
            case 1:
                return new LogInFragment();
            case 2:
                return new LibraryMapFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // number of tabs
        return 3;
    }
}
