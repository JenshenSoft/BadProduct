package ua.regin.badproduct.ui.view

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet

class BetterViewPager(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {

    protected var listener: ViewPager.OnPageChangeListener? = null

    override fun addOnPageChangeListener(listener: OnPageChangeListener?) {
        super.addOnPageChangeListener(listener)
        this.listener = listener
    }

    override fun setCurrentItem(item: Int) {
        var invokeMeLater = false
        if (super.getCurrentItem() == 0 && item == 0)
            invokeMeLater = true
        super.setCurrentItem(item)
        if (invokeMeLater && listener != null)
            listener!!.onPageSelected(0)
    }
}