package ru.mitapp.umai.ui.home.main.templates.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.mitapp.umai.R
import ru.mitapp.umai.databinding.TemplatesListViewBinding
import ru.mitapp.umai.models.templates_models.MyTemplate

class TemplatesActivityAdapter(var myTemplatesList: ArrayList<MyTemplate>,
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

        fun onBind(template: MyTemplate, listener: Listener) {
            binding.templatesView = template
            itemView.setOnClickListener {
                listener.onItemClick(template)
            }
            binding.imgMore.setOnClickListener {
                listener.onItemMoreClick(template)
            }
        }
    }
    interface Listener {
        fun onItemClick(template: MyTemplate)
        fun onItemMoreClick(template: MyTemplate)
    }
}