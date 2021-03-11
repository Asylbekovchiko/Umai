package ru.mitapp.umai.ui.home.main.templates.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.mitapp.umai.R
import ru.mitapp.umai.databinding.ChooseServiceItemBinding
import ru.mitapp.umai.ui.home.main.templates.model.ChooseServiceModel
import ru.mitapp.umai.ui.home.service.viewmodel.ServiceViewModel

class ChooseServiceAdapter(var serviceList: ArrayList<ChooseServiceModel>,var listener: Listener)
    : RecyclerView.Adapter<ChooseServiceAdapter.ChooseVH>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChooseServiceAdapter.ChooseVH {
        val binding: ChooseServiceItemBinding? = DataBindingUtil.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.choose_service_item, parent, false
            )
        )

        return ChooseVH(binding!!)
    }

    override fun onBindViewHolder(holder: ChooseServiceAdapter.ChooseVH, position: Int) {
        holder.onBind(serviceList[position], listener)
    }

    override fun getItemCount(): Int {
        return serviceList.size
    }

    class ChooseVH(val binding: ChooseServiceItemBinding)
        :RecyclerView.ViewHolder(binding.root){

            fun onBind(serviceViewModel: ChooseServiceModel, listener: Listener){
                binding.chooseView = serviceViewModel

                itemView.setOnClickListener {
                    listener.onItemClick(position)
                }

            }

    }

    interface Listener {
        fun onItemClick(position: Int)
    }
}