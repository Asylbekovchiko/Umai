package ru.mitapp.umai.ui.main.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.mitapp.umai.R
import ru.mitapp.umai.ui.main.view_model.MapFragmentViewModel

class MapFragment : Fragment() {

    companion object {
        fun newInstance() = MapFragment()
    }

    private lateinit var viewModel: MapFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.map_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MapFragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}