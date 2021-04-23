package ru.mitapp.umai.ui.main.detail

import android.annotation.SuppressLint
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityDetailNewsBinding
import java.text.SimpleDateFormat
import java.util.*

class DetailNewsActivity : BaseActivity<ActivityDetailNewsBinding>(R.layout.activity_detail_news) {

    override fun setupView() {
        setSupportActionBar(binding!!.detailToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val title = intent.getStringExtra("Title")
        val content = intent.getStringExtra("Content")
        val time = intent.getStringExtra("Time")

        binding!!.newsTime.text = parseDate(time.toString())
        binding!!.newsDesc.text = content
        binding!!.newsTitle.text = title
    }
    @SuppressLint("SimpleDateFormat")
    fun parseDate(serverDate: String): String {
        var sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'Z'")
        val date = sdf.parse(serverDate)
        sdf = SimpleDateFormat("d MMMM yyyy")
        return sdf.format(date!!)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}