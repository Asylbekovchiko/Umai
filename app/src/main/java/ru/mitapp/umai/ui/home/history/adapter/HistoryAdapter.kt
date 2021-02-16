package ru.mitapp.umai.ui.home.history.adapter

import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.mitapp.umai.R
import ru.mitapp.umai.databinding.ItemHistoryBinding
import ru.mitapp.umai.models.history_model.HistoryModel
import java.util.ArrayList

class HistoryAdapter(var list: ArrayList<HistoryModel>, var listener: Listener): RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding: ItemHistoryBinding? = DataBindingUtil.bind(android.view.LayoutInflater.from(parent.context).inflate(
            R.layout.item_history, parent, false))

        return HistoryViewHolder(binding!!)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.onBind(list[position], listener)
    }

    class HistoryViewHolder(var binding: ItemHistoryBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(model: HistoryModel, listener: Listener){
            binding.model = model
            itemView.setOnClickListener {
                listener.onItemClick(position)
            }
        }
    }

    interface Listener{
        fun onItemClick(position: Int)
    }
}