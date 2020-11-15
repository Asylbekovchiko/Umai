package ru.mitapp.umai.base

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, url: String) {
    Glide.with(imageView.context).load(url).into(imageView)


    @BindingAdapter("imageSrc")
    fun setImageSrc5(imageView: ImageView, imageId: Int) {
       imageView.setImageResource(imageId)
    }

}
