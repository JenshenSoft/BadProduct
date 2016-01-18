package ua.regin.badproduct.util

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator

object AnimationUtils {

    fun animateColorChange(objectToAnimate: Any, param: String, start: Int, end: Int) {
        val colorAnim = ObjectAnimator.ofInt(objectToAnimate, param, start, end)
        colorAnim.setDuration(500)
        colorAnim.setEvaluator(ArgbEvaluator())
        colorAnim.start()
    }
}
