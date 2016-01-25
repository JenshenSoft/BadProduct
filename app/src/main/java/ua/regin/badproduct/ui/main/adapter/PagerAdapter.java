package ua.regin.badproduct.ui.main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ua.regin.badproduct.ui.addictive.AdditiveFragment_;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private static final int PAGE_COUNT = 3;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = AdditiveFragment_.builder().dangerFrom(0).dangerTo(5).build();
                break;
            case 1:
                fragment = AdditiveFragment_.builder().dangerFrom(0).dangerTo(2).build();
                break;
            case 2:
                fragment = AdditiveFragment_.builder().dangerFrom(2).dangerTo(5).build();
                break;
            default:
                throw new RuntimeException("Unknown fragment position");
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}