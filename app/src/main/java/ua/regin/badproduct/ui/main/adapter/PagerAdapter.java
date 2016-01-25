package ua.regin.badproduct.ui.main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ua.regin.badproduct.model.Danger;
import ua.regin.badproduct.ui.addictive.AdditiveListFragment;

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
                fragment = AdditiveListFragment.Companion.newInstance(new Danger(-1, 5));
                break;
            case 1:
                fragment = AdditiveListFragment.Companion.newInstance(new Danger(0, 2));
                break;
            case 2:
                fragment = AdditiveListFragment.Companion.newInstance(new Danger(2, 5));
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