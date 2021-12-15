package com.rongcheng.hi.library.util

import android.view.View
import android.view.ViewGroup
import java.util.*

class HiViewUtil {

    companion object {

        fun <T> findTypeView(group: ViewGroup?, cls: Class<T>): T? {
            if (group == null) return null
            val deque: Deque<View> = ArrayDeque()
            deque.add(group)
            while (!deque.isEmpty()) {
                val node = deque.removeFirst()
                if (cls.isInstance(node)) {
                    return cls.cast(node)
                } else if (node is ViewGroup) {
                    for (i in 0 until node.childCount) {
                        deque.add(node.getChildAt(i))
                    }
                }
            }
            return null
        }
    }
}