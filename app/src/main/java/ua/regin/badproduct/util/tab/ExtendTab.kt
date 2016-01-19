package ua.regin.badproduct.util.tab

import android.graphics.Color
import android.support.design.widget.TabLayout

fun TabLayout.Tab.selected(isSelected: Boolean): TabLayout.Tab {
    icon.setTint(Color.parseColor(if (isSelected) "#FFFFFF" else "#212121"));
    return this;
}
