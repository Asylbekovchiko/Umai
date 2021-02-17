package ru.mitapp.umai.ui.home.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.mitapp.umai.R
import ru.mitapp.umai.databinding.TemplateItemBinding
import ru.mitapp.umai.models.home.Template

class TemplatesAdapter(var items : ArrayList<Template>, var listener : Listener) : RecyclerView.Adapter<TemplatesAdapter.TemplatesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemplatesViewHolder {
        val binding : TemplateItemBinding? = DataBindingUtil.bind(LayoutInflater.from(parent.context).inflate(
            R.layout.template_item, parent, false))


        return TemplatesViewHolder(binding!!)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TemplatesViewHolder, position: Int) {
        holder.onBind(items[position], listener)
    }

    class TemplatesViewHolder(var binding : TemplateItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(template : Template, listener: Listener){
            binding.template = template

            itemView.setOnClickListener{
                listener.onTemplatesClickListener(template)
            }
        }
    }

    interface Listener{
        fun onTemplatesClickListener(template : Template)
    }
}