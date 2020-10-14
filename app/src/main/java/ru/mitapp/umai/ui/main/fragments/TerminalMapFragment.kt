package ru.mitapp.umai.ui.main.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.mitapp.umai.R
import ru.mitapp.umai.ui.main.view_model.TerminalMapViewModel

class TerminalMapFragment : Fragment() {

    companion object {
        fun newInstance() = TerminalMapFragment()
    }

    private lateinit var viewModel: TerminalMapViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.terminal_map_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TerminalMapViewModel::class.java)
        // TODO: Use the ViewModel
    }

}