package ru.mitapp.umai.ui.main.terminal.terminal_dialog

import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseDialogFragment
import ru.mitapp.umai.databinding.DialogTerminalFilterBinding
import ru.mitapp.umai.models.TerminalFilter
import ru.mitapp.umai.ui.main.terminal.adapter.TerminalFilterAdapter
import ru.mitapp.umai.ui.main.terminal.TerminalListener
import ru.mitapp.umai.utils.RecyclerAnimation

class TerminalFilterDialog(var listener : TerminalListener) : BaseDialogFragment<DialogTerminalFilterBinding>(R.layout.dialog_terminal_filter), TerminalFilterAdapter.Listener {

    private lateinit var adapter : TerminalFilterAdapter
    private var filters : ArrayList<TerminalFilter> = ArrayList()


    override fun init() {
        if (filters.isEmpty()){
            fillFilterList()
        }

        setupRecycler()

        binding.closeButton.setOnClickListener{
            dismiss()
        }
    }

    override fun onFilterClick(terminalFilter: TerminalFilter) {
        adapter.notifyDataSetChanged()
    }

    private fun setupRecycler(){
        RecyclerAnimation.startAnimation(binding.filterRecycler, R.anim.main_recycler_anim_layout)
        adapter = TerminalFilterAdapter(filters, this)
        binding.filterRecycler.adapter = adapter

    }

    fun fillFilterList(){
        filters.add(TerminalFilter("Банкоматы", "A", false, R.drawable.ic_atm))
        filters.add(TerminalFilter("Терминалы", "T", false, R.drawable.ic_terminal))
        filters.add(TerminalFilter("Офисы", "O", false, R.drawable.ic_ofice))
    }

}