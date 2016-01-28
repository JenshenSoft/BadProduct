package ua.regin.badproduct.util.fragment

import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import ua.regin.badproduct.R
import ua.regin.badproduct.ui.BaseActivity

fun Fragment.setToolbar(toolbar: Toolbar) {
    var activity = activity as BaseActivity;
    activity.setSupportActionBar(toolbar);

}

