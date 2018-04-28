package com.codegeek.fblalibraryapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * This class controls the three main fragments in the app and
 * returns the appropriate fragment when the user switches between
 * fragments in the app.
 *
 * Bugs:
 *
 * @Shreshth Kharbanda
 */
public class TabsPagerAdapter extends FragmentPagerAdapter{
    TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * This method recieved the index number of a fragment then retirns the corrosponding
     * fragment.
     *
     * @param (index) recieves the index of the fragment that needs to be returned.
     * @return returns the fragment corrosponding to the given index number.
     */
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

    /**
     * This method returns the number of tabs/fragments in the app
     *
     * @return returns the number of tabs or fragments in the app.
     */
    @Override
    public int getCount() {
        // number of tabs
        return 3;
    }
}
