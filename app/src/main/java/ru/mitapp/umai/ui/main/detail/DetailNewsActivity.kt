package ru.mitapp.umai.ui.main.detail

import android.annotation.SuppressLint
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityDetailNewsBinding
import java.text.SimpleDateFormat
import java.util.*

class DetailNewsActivity : BaseActivity<ActivityDetailNewsBinding>(R.layout.activity_detail_news) {


    @SuppressLint("SimpleDateFormat")
    override fun setupView() {
        setSupportActionBar(binding!!.detailToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val title = intent.getStringExtra("Title")
        val content = intent.getStringExtra("Content")
        val time = intent.getStringExtra("Time")

        val format = SimpleDateFormat("dd-MM-yyyy'T'", Locale.ENGLISH)
        val date: String = format.parse(time!!)!!.toString()
        binding!!.newsTime.text = date
        binding!!.newsDesc.text = content
        binding!!.newsTitle.text = title
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}