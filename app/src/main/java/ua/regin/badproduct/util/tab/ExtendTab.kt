package ua.regin.badproduct.util.tab

import android.content.Context
import android.support.design.widget.TabLayout
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat

fun TabLayout.Tab.selected(context: Context, isSelected: Boolean): TabLayout.Tab {
    var wrapDrawable = DrawableCompat.wrap(icon);
    DrawableCompat.setTint(wrapDrawable, ContextCompat.getColor(context, if (isSelected) android.R.color.white else android.R.color.black));
    return this;
}
