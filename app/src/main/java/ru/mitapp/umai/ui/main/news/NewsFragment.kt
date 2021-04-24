package ru.mitapp.umai.ui.main.news

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.tools.build.jetifier.core.utils.Log
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.NewsFragmentBinding
import ru.mitapp.umai.models.news.News
import ru.mitapp.umai.models.service.SubCategory
import ru.mitapp.umai.ui.home.service.adapter.SubCategoryAdapter
import ru.mitapp.umai.ui.main.detail.DetailNewsActivity
import ru.mitapp.umai.ui.main.detail.DetailNewsViewModel
import ru.mitapp.umai.utils.RecyclerAnimation

class NewsFragment : BaseFragment<NewsFragmentBinding>(R.layout.news_fragment),
    NewsAdapter.Listener {

    private lateinit var viewModel: NewsFragmentViewModel
    var newsList = ArrayList<News>()

    override fun setupView() {
        viewModel = ViewModelProvider(this).get(NewsFragmentViewModel::class.java)
        binding!!.refreshLayout.setOnRefreshListener {
            newsList.clear()
            getNews()
            binding!!.refreshLayout.isRefreshing = false
        }

        getNews()

    }

    fun getNews(){
        viewModel.getNews()
        viewModel.newsData.observe(this, Observer {
            if (it.data != null) {
                newsList = it.data!!
                setUpRecycler()
            }
        })
    }

    fun setUpRecycler() {
        binding!!.recylerNews.adapter = NewsAdapter(newsList, this)
        binding!!.recylerNews.layoutManager = LinearLayoutManager(requireActivity())
    }


    override fun onItemClick(news: News) {
        val intent = Intent(requireContext(), DetailNewsActivity::class.java)
        intent.putExtra("news", news)
        startActivity(intent)
    }

}