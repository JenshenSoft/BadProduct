package ua.regin.badproduct.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AttrRes;
import android.support.annotation.IntegerRes;

public class ThemeUtils {

    public static int getResourceFromAttribute(Context context, @AttrRes int attributeId) {
        int[] attr = new int[]{attributeId};
        TypedArray typedArray = context.obtainStyledAttributes(attr);
        return typedArray.getResourceId(0, 0);
    }
}
