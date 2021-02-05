package ru.mitapp.umai.ui.main.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.NewsFragmentBinding
import ru.mitapp.umai.ui.main.view_model.NewsFragmentViewModel

class NewsFragment : BaseFragment<NewsFragmentBinding>(R.layout.news_fragment) {

    var index = 0

    private lateinit var viewModel: NewsFragmentViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NewsFragmentViewModel::class.java)

        binding.refreshLayout.setOnRefreshListener {
            index++
            binding.textView.text = index.toString()
            binding.refreshLayout.isRefreshing = false
        }
    }

    override fun setupView() {
    }

}