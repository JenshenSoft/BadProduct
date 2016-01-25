package ua.regin.badproduct.ui.main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ua.regin.badproduct.ui.addictive.AdditiveFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private final static int PAGE_COUNT = 3;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = AdditiveFragment.Companion.newInstance(-1, 5);
                break;
            case 1:
                fragment = AdditiveFragment.Companion.newInstance(0, 2);
                break;
            case 2:
                fragment = AdditiveFragment.Companion.newInstance(2, 5);
                break;
            default:
                throw new RuntimeException("Unknown fragment");
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}