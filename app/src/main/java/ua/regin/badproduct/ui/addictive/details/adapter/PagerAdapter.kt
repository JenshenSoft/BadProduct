package ua.regin.badproduct.ui.addictive.details.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import ua.regin.badproduct.model.Additive
import ua.regin.badproduct.ui.addictive.details.AdditiveDetailsFragment

class AdditivePagerAdapter(fm: FragmentManager, var additiveList: List<Additive>) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return AdditiveDetailsFragment.newInstance(additiveList[position]);
    }

    override fun getCount(): Int {
        return additiveList.count();
    }
}