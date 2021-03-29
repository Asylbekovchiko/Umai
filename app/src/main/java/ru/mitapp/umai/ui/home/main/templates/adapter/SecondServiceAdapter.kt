package ru.mitapp.umai.ui.home.main.templates.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.mitapp.umai.R
import ru.mitapp.umai.databinding.SecondServiceItemBinding
import ru.mitapp.umai.models.templates_models.SecondServiceModel

class SecondServiceAdapter(val secondServiceList: ArrayList<SecondServiceModel>, var listener: Listener)
    : RecyclerView.Adapter<SecondServiceAdapter.SecondSerVH>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SecondSerVH {
        val binding: SecondServiceItemBinding? = DataBindingUtil.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.second_service_item, parent, false
            )
        )

        return SecondSerVH(binding!!)
    }

    override fun onBindViewHolder(holder: SecondSerVH, position: Int) {
        holder.onBind(secondServiceList[position], listener)
    }

    override fun getItemCount(): Int {
        return secondServiceList.size
    }
    class SecondSerVH(val binding:SecondServiceItemBinding)
        :RecyclerView.ViewHolder(binding.root){

            fun onBind(secondSerViewModel: SecondServiceModel, listener: Listener){
                binding.secondServiceView = secondSerViewModel
                itemView.setOnClickListener {
                    listener.onItemClick(position)
                }

            }


    }
    interface Listener {
        fun onItemClick(position: Int)
    }
}