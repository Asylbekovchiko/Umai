package ru.mitapp.umai.base

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

open class UnScrollViewPager : ViewPager {
    private var disable = false

    constructor(context: Context?) : super(context!!)
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs)

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return !disable && super.onInterceptTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return !disable && super.onTouchEvent(event)
    }

    fun disableScroll(disable: Boolean) {
        this.disable = disable
    }
}
