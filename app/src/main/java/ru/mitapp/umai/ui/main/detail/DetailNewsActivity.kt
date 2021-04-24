package ru.mitapp.umai.ui.main.detail

import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityDetailNewsBinding
import ru.mitapp.umai.models.news.News

class DetailNewsActivity : BaseActivity<ActivityDetailNewsBinding>(R.layout.activity_detail_news) {

    override fun setupView() {
        setSupportActionBar(binding!!.detailToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val news = intent.extras?.getSerializable("news")
        binding!!.news = news as News?
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}