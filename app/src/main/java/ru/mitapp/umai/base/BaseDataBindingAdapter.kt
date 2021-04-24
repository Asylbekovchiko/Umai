package ru.mitapp.umai.base
import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*


@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, url: String?) {
    Glide.with(imageView.context).load(url).into(imageView)


    @BindingAdapter("imageSrc")
    fun setImageSrc5(imageView: ImageView, imageId: Int) {
       imageView.setImageResource(imageId)
    }

}

@SuppressLint("SimpleDateFormat")
@BindingAdapter("convertDate")
fun parseDate(textView: TextView, serverDate: Date){
    val sdf = SimpleDateFormat("dd MMMM yyyy")
    textView.text = sdf.format(serverDate)
}
