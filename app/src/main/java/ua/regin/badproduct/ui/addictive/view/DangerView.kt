package ua.regin.badproduct.ui.addictive.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import java.util.*

class DangerView : LinearLayout {

    private val DANGER_COUNT = 4;
    private var viewList: MutableList<View> = ArrayList();

    constructor(context: Context) : super(context) {
        init();
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs, 0) {
        init();
    }

    fun setDangerCount(count: Int) {
        if (count > 0) {
            for (index in 0..count) {
                viewList[index].setBackgroundColor(context.getColor(android.R.color.holo_red_dark));
            }
        }
    }

    fun init() {
        var params = LinearLayout.LayoutParams(50, 50, 1f)
        params.setMargins(2, 2, 2, 2);
        for (index in 0..DANGER_COUNT) {
            var view = View(context);
            view.layoutParams = params;
            view.setBackgroundColor(context.getColor(android.R.color.holo_green_dark))
            addView(view);
            viewList.add(view);
        }
    }
}
