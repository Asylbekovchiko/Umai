package ru.mitapp.umai.ui.home.service.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.mitapp.umai.R
import ru.mitapp.umai.databinding.ServiceItemBinding
import ru.mitapp.umai.models.service.ServiceModel
import java.util.ArrayList

class ServiceAdapter(var list: ArrayList<ServiceModel>, var listener: Listener) :
    RecyclerView.Adapter<ServiceAdapter.ServiceVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceVH {
        val binding: ServiceItemBinding? = DataBindingUtil.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.service_item, parent, false
            )
        )

        return ServiceVH(
            binding!!
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ServiceVH, position: Int) {
        holder.onBind(list[position], listener)
    }


    class ServiceVH(var binding: ServiceItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(serviceModel: ServiceModel, listener: Listener) {
            binding.service = serviceModel

            itemView.setOnClickListener {
                listener.onItemClick(serviceModel)
            }

        }

    }

    interface Listener {
        fun onItemClick(serviceModel: ServiceModel)
    }

}