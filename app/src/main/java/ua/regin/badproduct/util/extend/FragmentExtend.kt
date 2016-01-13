package ua.regin.badproduct.util.extend

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import ua.regin.badproduct.R

fun Fragment.show(supportFragmentManager: FragmentManager) {
    supportFragmentManager.beginTransaction()
            .replace(R.id.containerView, this)
            .commit();
}
