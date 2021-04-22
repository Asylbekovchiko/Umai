package ru.mitapp.umai.ui.main.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.mitapp.umai.R
import ru.mitapp.umai.databinding.ItemNewsBinding
import ru.mitapp.umai.models.news.News
import ru.mitapp.umai.models.service.ServiceModel
import ru.mitapp.umai.ui.home.service.adapter.ServiceAdapter
import java.util.ArrayList

class NewsAdapter(var newsList: ArrayList<News>, var listener: Listener)
    : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding: ItemNewsBinding? = DataBindingUtil.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_news, parent, false
            )
        )
        return NewsViewHolder(binding!!)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.onBind(newsList[position], listener)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    class NewsViewHolder(var binding: ItemNewsBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(news: News, listener: Listener) {
            binding.news = news

            itemView.setOnClickListener {
                listener.onItemClick(news)
            }

        }
    }

    interface Listener {
        fun onItemClick(news: News)
    }
}