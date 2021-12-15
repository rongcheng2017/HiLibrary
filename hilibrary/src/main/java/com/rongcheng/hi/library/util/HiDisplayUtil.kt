package com.rongcheng.hi.library.util

import android.content.Context
import android.content.res.Resources
import android.graphics.Point
import android.util.TypedValue
import android.view.WindowManager

class HiDisplayUtil {


    companion object {
        fun dp2px(dp: Float, resources: Resources): Float =
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                resources.displayMetrics
            )

        fun getDisplayWidthInPx(context: Context): Int {
            val wm: WindowManager? =
                context.getSystemService(Context.WINDOW_SERVICE) as WindowManager?
            return wm?.let {
                val size = Point()
                it.defaultDisplay.getSize(size)
                size.x
            } ?: let {
                0
            }
        }

        fun getDisplayHeightInPx(context: Context): Int {
            val wm: WindowManager? =
                context.getSystemService(Context.WINDOW_SERVICE) as WindowManager?
            return wm?.let {
                val size = Point()
                it.defaultDisplay.getSize(size)
                size.y
            } ?: let {
                0
            }
        }

    }
}