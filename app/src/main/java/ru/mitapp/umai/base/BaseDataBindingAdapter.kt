package ru.mitapp.umai.base

import android.annotation.SuppressLint
import android.os.Build
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
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
@BindingAdapter("convertDate", "formatDate")
fun parseDate(textView: TextView, date: Date, formatDate: String) {
    val sdf = SimpleDateFormat(formatDate)
    textView.text = sdf.format(date)
}


@RequiresApi(Build.VERSION_CODES.O)
@BindingAdapter("loadBase64")
fun loadBase64(imageView: ImageView, imageBytes: String?){
    if (!imageBytes.isNullOrEmpty()){
        Glide.with(imageView.context)
            .asBitmap()
            .load(Base64.getDecoder().decode(imageBytes))
            .placeholder(R.drawable.ic_umai_logo)
            .into(imageView)
    }else{
        loadStub(imageView)
    }
}

@BindingAdapter("loadImageForDetailPayment")
fun getImage(imageView: ImageView, type: String?){
    val circularProgressDrawable = CircularProgressDrawable(imageView.context)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.start()
    if (type.isNullOrEmpty()){
        loadStub(imageView)
    }else{
        val url = "https://umai.kg/files/service-providers/$type.png"
        Glide.with(imageView.context).load(url).placeholder(circularProgressDrawable).into(imageView)
    }

}

fun loadStub(imageView: ImageView){
    Glide.with(imageView.context).load(R.drawable.ic_umai_logo).into(imageView)
}

