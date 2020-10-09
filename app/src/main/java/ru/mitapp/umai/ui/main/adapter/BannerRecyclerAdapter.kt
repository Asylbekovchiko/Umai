package ru.mitapp.umai.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.mitapp.umai.R
import ru.mitapp.umai.databinding.BannerItemBinding

class BannerRecyclerAdapter(var list: ArrayList<Int>, var listener : Listener) : RecyclerView.Adapter<BannerRecyclerAdapter.BannerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val binding : BannerItemBinding? = DataBindingUtil.bind(LayoutInflater.from(parent.context).inflate(
            R.layout.banner_item, parent, false))

        return BannerViewHolder(binding!!)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.onBind(list[position], listener)
    }

    class BannerViewHolder(var binding : BannerItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(imageId : Int, listener : Listener){
            Glide.with(itemView.context).load(imageId).into(binding.bannerImage)

            itemView.setOnClickListener{
                listener.onBannerClick()
            }
        }
    }

    interface Listener{
        fun onBannerClick()
    }
}