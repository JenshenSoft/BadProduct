package ua.regin.badproduct.util.fragment

import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import ua.regin.badproduct.R
import ua.regin.badproduct.ui.BaseActivity

fun Fragment.setToolbar(toolbar: Toolbar) {
    toolbar.setPadding(0, getStatusBarHeight(), 0, 0);
    toolbar.layoutParams.height = toolbar.layoutParams.height + getStatusBarHeight();
    var activity = activity as BaseActivity;
    activity.setSupportActionBar(toolbar);
    activity.supportActionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_24px);
    activity.supportActionBar.setDisplayHomeAsUpEnabled(true);
}

private fun Fragment.getStatusBarHeight(): Int {
    var result = 0;
    var resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
    if (resourceId > 0) {
        result = resources.getDimensionPixelSize(resourceId);
    }
    return result;
}