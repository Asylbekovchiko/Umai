package ru.mitapp.umai.ui.home.service.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.mitapp.umai.R
import ru.mitapp.umai.databinding.PartnersItemBinding
import ru.mitapp.umai.databinding.ServiceItemBinding
import ru.mitapp.umai.models.partner.Partners
import ru.mitapp.umai.models.service_model.ServiceModel
import java.util.ArrayList

class PartnersAdapter(var list: ArrayList<Partners>, var listener: Listener) :
    RecyclerView.Adapter<PartnersAdapter.PartnersVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartnersVH {
        val binding: PartnersItemBinding? = DataBindingUtil.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.partners_item, parent, false
            )
        )

        return PartnersVH(binding!!)
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: PartnersVH, position: Int) {
    }


    class PartnersVH(var binding: PartnersItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(serviceModel: ServiceModel, listener: Listener) {
            itemView.setOnClickListener {
                listener.onItemClick(position)
            }

        }

    }

    interface Listener {
        fun onItemClick(position: Int)
    }

}