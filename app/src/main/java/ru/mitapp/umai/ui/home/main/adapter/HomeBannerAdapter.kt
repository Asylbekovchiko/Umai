package ru.mitapp.umai.ui.home.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.mitapp.umai.R
import ru.mitapp.umai.databinding.HomeBannerItemBinding
import ru.mitapp.umai.models.home.Banner
import kotlin.collections.ArrayList

class HomeBannerAdapter(var items : ArrayList<Banner>, var listener : Listener) : RecyclerView.Adapter<HomeBannerAdapter.HomeBannerVH>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBannerVH {
        val binding : HomeBannerItemBinding? = DataBindingUtil.bind(LayoutInflater.from(parent.context).inflate(
            R.layout.home_banner_item, parent, false))


        return HomeBannerVH(binding!!)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: HomeBannerVH, position: Int) {
        holder.onBind(items[position], listener)
    }


    class HomeBannerVH(var binding : HomeBannerItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(banner: Banner, listener: Listener){
            binding.bannerTitle.text = banner.title
            binding.mainLayout.setBackgroundResource(banner.background!!)


            itemView.setOnClickListener{
                listener.onBannerClickListener(banner)
            }
        }

    }

    interface Listener{
        fun onBannerClickListener(banner: Banner)
    }



}