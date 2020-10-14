package ru.mitapp.umai.ui.main.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.TerminalFragmentBinding
import ru.mitapp.umai.ui.main.view_model.TerminalFragmentViewModel

class TerminalFragment : BaseFragment<TerminalFragmentBinding>(R.layout.terminal_fragment) {


    private lateinit var viewModel: TerminalFragmentViewModel


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TerminalFragmentViewModel::class.java)

    }

    override fun init() {

    }

}