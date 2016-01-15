package ua.regin.badproduct.util.extend

import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import ua.regin.badproduct.R

fun Fragment.show(supportFragmentManager: FragmentManager) {
    supportFragmentManager.beginTransaction()
            .replace(R.id.containerView, this)
            .commit();
}

fun Fragment.setToolbar(toolbar: Toolbar, @StringRes titleId: Int) {
    toolbar.setTitle(titleId);
    (activity as AppCompatActivity).setSupportActionBar(toolbar);
}
