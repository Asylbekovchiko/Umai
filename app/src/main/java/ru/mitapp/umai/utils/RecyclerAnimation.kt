package ru.mitapp.umai.utils

import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.recyclerview.widget.RecyclerView

object RecyclerAnimation {

    fun startAnimation(recyclerView: RecyclerView, animationResource : Int){
        var controller : LayoutAnimationController? = null
        controller = AnimationUtils.loadLayoutAnimation(recyclerView.context, animationResource)
        recyclerView.layoutAnimation = controller
        recyclerView.scheduleLayoutAnimation()
    }
}