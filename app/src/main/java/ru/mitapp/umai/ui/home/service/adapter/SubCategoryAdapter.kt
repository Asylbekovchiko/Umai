package ru.mitapp.umai.ui.home.service.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.mitapp.umai.R
import ru.mitapp.umai.databinding.SubCategoryItemBinding
import ru.mitapp.umai.models.service.SubCategory

class SubCategoryAdapter(var items : ArrayList<SubCategory>, var listener : Listener) : RecyclerView.Adapter<SubCategoryAdapter.SubCategoryViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryViewHolder {
        val binding : SubCategoryItemBinding? = DataBindingUtil.bind(LayoutInflater.from(parent.context).inflate(
            R.layout.sub_category_item, parent, false))

        return SubCategoryViewHolder(binding!!)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: SubCategoryViewHolder, position: Int) {
        holder.onBind(items[position], listener)
    }


    class SubCategoryViewHolder(var binding : SubCategoryItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(subCategory: SubCategory, listener: Listener){
            binding.subCategory = subCategory


            itemView.setOnClickListener{
                listener.onSubCategoryClickListener(subCategory)
            }
        }
    }

    interface Listener{
        fun onSubCategoryClickListener(subCategory: SubCategory)
    }
}