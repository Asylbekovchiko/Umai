package ru.mitapp.umai.ui.home.service.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.partners_item.view.*
import ru.mitapp.umai.R
import ru.mitapp.umai.databinding.PartnersItemBinding
import ru.mitapp.umai.databinding.ServiceItemBinding
import ru.mitapp.umai.models.partner.Partners
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
        return list.size
    }

    override fun onBindViewHolder(holder: PartnersVH, position: Int) {
        holder.onBind(list[position], listener)


    }


    class PartnersVH(var binding: PartnersItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(partners: Partners, listener: Listener) {
            itemView.titlePartners.text = partners.title
            itemView.descriptionPartners.text = partners.description


            itemView.setOnClickListener {
                listener.onClick(partners)
            }

        }

    }


    interface Listener {
        fun onClick(partners: Partners)
    }

}