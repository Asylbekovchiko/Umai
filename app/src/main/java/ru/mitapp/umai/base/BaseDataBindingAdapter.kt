package ru.mitapp.umai.base

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.anggastudio.dynamicimagegetter.DynamicImageGetter
import com.bumptech.glide.Glide
import ru.mitapp.umai.R
import java.text.SimpleDateFormat
import java.util.*


@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, url: String?) {
    Glide.with(imageView.context).load(url).placeholder(R.drawable.ic_umai_logotip).into(imageView)
}



@BindingAdapter("imageSrc")
fun setImageSrc5(imageView: ImageView, imageId: Int) {
    imageView.setImageResource(imageId)
}

@SuppressLint("SimpleDateFormat")
@BindingAdapter("convertDate","formatDate")
fun parseDate(textView: TextView, date: Date, formatDate: String) {
    val sdf = SimpleDateFormat(formatDate)
    textView.text = sdf.format(date)
}


@BindingAdapter("loadHtmlImg")
fun loadHtml(textView: TextView, url: String){
    DynamicImageGetter.with(textView.context)
        .load(url)
        .mode(DynamicImageGetter.FULL_WIDTH)
        .into(textView)
}
