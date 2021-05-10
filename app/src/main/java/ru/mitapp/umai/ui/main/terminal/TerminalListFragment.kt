package ru.mitapp.umai.ui.main.terminal

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.TerminalListFragmentBinding
import ru.mitapp.umai.models.Terminal
import ru.mitapp.umai.ui.main.terminal.adapter.TerminalRvAdapter
import ru.mitapp.umai.ui.main.terminal.terminal_dialog.TerminalMapDialog
import ru.mitapp.umai.ui.main.terminal.viewmodel.TerminalListViewModel

class TerminalListFragment(var listener: TerminalListener, var terminals: ArrayList<Terminal>) :
    BaseFragment<TerminalListFragmentBinding>(R.layout.terminal_list_fragment),
    TerminalRvAdapter.Listener, TerminalMapDialog.ClickMarker {
    private lateinit var dialogSheet: TerminalMapDialog
    private lateinit var viewModel: TerminalListViewModel
    private lateinit var adapter: TerminalRvAdapter

    override fun setupView() {
        viewModel = ViewModelProviders.of(this).get(TerminalListViewModel::class.java)
        setupRecycler()


    }


    private fun setupRecycler() {
        binding!!.terminalRecycler.layoutManager = LinearLayoutManager(requireActivity())
        binding!!.terminalRecycler.adapter = TerminalRvAdapter(terminals, this)
    }

    override fun onTerminalClick(terminal: Terminal) {
        dialogSheet = TerminalMapDialog()
        dialogSheet.setCallback(this)
        val bundle =Bundle()
        bundle.putParcelable("terminal",terminal)
//        bundle.putString("address", terminal.address)
//        bundle.putString("work_time", terminal.workingTime)
        dialogSheet.arguments = bundle
        dialogSheet.show(activity?.supportFragmentManager!!, "")
    }

    override fun onClickButtonMarker(terminal: Terminal) {
        listener.showInMap(terminal)
    }
}