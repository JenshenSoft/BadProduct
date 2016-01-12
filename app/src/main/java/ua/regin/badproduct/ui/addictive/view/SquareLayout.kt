package ua.regin.badproduct.ui.addictive.view

import android.content.Context
import android.support.v7.widget.CardView
import android.util.AttributeSet

class SquareLayout : CardView {

    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs, 0) {
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
}
