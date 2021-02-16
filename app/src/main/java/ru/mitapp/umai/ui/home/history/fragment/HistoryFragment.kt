package ru.mitapp.umai.ui.home.history.fragment


import androidx.lifecycle.ViewModelProvider
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.FragmentHistoryBinding
import ru.mitapp.umai.models.history_model.HistoryModel
import ru.mitapp.umai.ui.home.history.viewmodel.HistoryViewModel
import ru.mitapp.umai.ui.home.history.adapter.HistoryAdapter
import java.util.ArrayList


class HistoryFragment : BaseFragment<FragmentHistoryBinding>(R.layout.fragment_history), HistoryAdapter.Listener {
    private lateinit var adapter: HistoryAdapter
    private lateinit var viewModel: HistoryViewModel
    var list = ArrayList<HistoryModel>()
    override fun setupView() {
        viewModel = ViewModelProvider(this).get(HistoryViewModel::class.java)

        binding.viewModel = viewModel
//        list.add(
//            HistoryModel("123", "1234", "234", "123", "123", "!234", "1234")
//        )
        viewModel.checkList(list)
        adapter = HistoryAdapter(list, this)
        binding.historyRecycler.adapter = adapter
    }

    override fun onItemClick(position: Int) {

    }

}