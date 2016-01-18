package ua.regin.badproduct.ui.addictive.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import ua.regin.badproduct.R
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
        for (index in 0..DANGER_COUNT) {
            if (index < count) {
                viewList[index].setBackgroundColor(context.getColor(R.color.colorPrimaryDarkRed));
            } else {
                viewList[index].setBackgroundColor(context.getColor(R.color.colorPrimaryGreen));
            }
        }
    }

    fun init() {
        var params = LinearLayout.LayoutParams(30, 15, 1f)
        params.setMargins(1, 1, 1, 1);
        for (index in 0..DANGER_COUNT) {
            var view = View(context);
            view.layoutParams = params;
            addView(view);
            viewList.add(view);
        }
    }
}
