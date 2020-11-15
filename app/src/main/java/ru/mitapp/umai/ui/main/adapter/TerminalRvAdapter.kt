package ru.mitapp.umai.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.mitapp.umai.R
import ru.mitapp.umai.databinding.TerminalItemBinding
import ru.mitapp.umai.models.Terminal

class TerminalRvAdapter(var list: ArrayList<Terminal>, var listener: Listener) :
    RecyclerView.Adapter<TerminalRvAdapter.TerminalViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TerminalViewHolder {
        val binding: TerminalItemBinding? = DataBindingUtil.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.terminal_item, parent, false
            )
        )


        return TerminalViewHolder(binding!!)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TerminalViewHolder, position: Int) {
        holder.onBind(list[position], listener)
    }

    class TerminalViewHolder(var binding: TerminalItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var mBinding = binding
        fun onBind(terminal: Terminal, listener: Listener) {
            binding.terminal = terminal

            when (terminal.type) {
                "T" -> binding.typeIndicator.setBackgroundResource(R.color.terminalIndicatorColor)
                "A" -> binding.typeIndicator.setBackgroundResource(R.color.atmIndicatorColor)
                "O" -> binding.typeIndicator.setBackgroundResource(R.color.officeIndicatorColor)
            }

            itemView.setOnClickListener {
                listener.onTerminalClick(terminal)
            }
        }
    }

    interface Listener {
        fun onTerminalClick(terminal: Terminal)
    }
}