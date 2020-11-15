package ru.mitapp.umai.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.mitapp.umai.R
import ru.mitapp.umai.databinding.TerminalFilterItemBinding
import ru.mitapp.umai.models.TerminalFilter

class TerminalFilterAdapter(var list : ArrayList<TerminalFilter>, var listener : Listener) : RecyclerView.Adapter<TerminalFilterAdapter.TerminalFilterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TerminalFilterViewHolder {
        val binding : TerminalFilterItemBinding? = DataBindingUtil.bind(LayoutInflater.from(parent.context).inflate(
            R.layout.terminal_filter_item, parent, false))


        return TerminalFilterViewHolder(binding!!)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TerminalFilterViewHolder, position: Int) {
        holder.onBind(list, list[position], listener)
    }

    class TerminalFilterViewHolder(var binding : TerminalFilterItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(filters : ArrayList<TerminalFilter>, filter: TerminalFilter, listener: Listener){
            binding.item = filter
            binding.filterIcon.setImageResource(filter.icon)
            if (filter.isSelected!!){
                binding.selectIcon.visibility = View.VISIBLE
                binding.filterLayout.setBackgroundResource(R.drawable.bg_select_filter_item)
                binding.filterName.setTextColor(itemView.context.resources.getColor(R.color.colorPrimary))
            } else{
                binding.selectIcon.visibility = View.GONE
                binding.filterLayout.setBackgroundResource(R.drawable.bg_not_select_filter_item)
                binding.filterName.setTextColor(itemView.context.resources.getColor(R.color.descriptionTextColor))
            }


            itemView.setOnClickListener{
                for (filt in filters){
                    filt.isSelected = false
                }

                filter.isSelected = true
                listener.onFilterClick(filter)
            }
        }
    }


    interface Listener{
        fun onFilterClick(terminalFilter: TerminalFilter)
    }
}