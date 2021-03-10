package ru.mitapp.umai.ui.home.main.templates.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.mitapp.umai.R
import ru.mitapp.umai.databinding.TemplatesListViewBinding
import ru.mitapp.umai.ui.home.main.templates.model.MyTemplatesModel
import ru.mitapp.umai.ui.home.service.adapter.ServiceAdapter

class TemplatesActivityAdapter(var myTemplatesList: ArrayList<MyTemplatesModel>,
    var listener: Listener):
    RecyclerView.Adapter<TemplatesActivityAdapter.TemplatesVH>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TemplatesVH {

        val binding: TemplatesListViewBinding? = DataBindingUtil.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.templates_list_view, parent, false
            )
        )

        return TemplatesVH(
            binding!!
        )
    }

    override fun onBindViewHolder(holder: TemplatesVH, position: Int) {
        holder.onBind(myTemplatesList[position], listener)
    }

    override fun getItemCount(): Int {
        return myTemplatesList.size
    }
    class TemplatesVH(var binding: TemplatesListViewBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun onBind(templatesModel: MyTemplatesModel, listener: Listener) {
            binding.templatesView = templatesModel
//            itemView.setOnClickListener {
//                listener.onItemClick(position)
//            }
            binding.imgMore.setOnClickListener {
                listener.onItemClick(position = position)
            }
        }
    }
    interface Listener {
        fun onItemClick(position: Int)
    }
}