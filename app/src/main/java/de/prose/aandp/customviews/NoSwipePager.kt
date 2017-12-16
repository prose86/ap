package de.prose.aandp.customviews

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by philip on 13/12/17.
 */
class NoSwipePager(context: Context, attrs : AttributeSet) : ViewPager(context, attrs) {

    //disable all gestures to avoid swiping
    override fun onTouchEvent(event : MotionEvent) = false
    override fun onInterceptTouchEvent(event: MotionEvent) = false
}