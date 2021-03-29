package ru.mitapp.umai.ui.home.history.fragment


import androidx.lifecycle.ViewModelProvider
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.FragmentHistoryBinding
import ru.mitapp.umai.models.history.HistoryModel
import ru.mitapp.umai.ui.home.history.viewmodel.HistoryViewModel
import ru.mitapp.umai.ui.home.history.adapter.HistoryAdapter
import ru.mitapp.umai.utils.RecyclerAnimation
import java.util.ArrayList


class HistoryFragment : BaseFragment<FragmentHistoryBinding>(R.layout.fragment_history),
    HistoryAdapter.Listener {
    private lateinit var adapter: HistoryAdapter
    private lateinit var viewModel: HistoryViewModel
    private var list = ArrayList<HistoryModel>()
    override fun setupView() {
        viewModel = ViewModelProvider(this).get(HistoryViewModel::class.java)

        binding!!.viewModel = viewModel

        setupRecycler()

        binding!!.refreshLayout.setOnRefreshListener {
            binding!!.refreshLayout.isRefreshing = false
            fillList()
            setupRecycler()
        }

    }

    private fun fillList() {
        list.add(HistoryModel("https://pbs.twimg.com/profile_images/1356962252780429313/ccjxrCjD_400x400.jpg","123", "Besmart", "**** **** 7054", "14/04/20 06:42", "2373,45 c", "Успешно!", "Пополнение"))
        list.add(HistoryModel("https://pbs.twimg.com/profile_images/1356962252780429313/ccjxrCjD_400x400.jpg","123", "Besmart", "**** **** 7054", "14/04/20 06:42", "2373,45 c", "Успешно!", "Пополнение"))
        list.add(HistoryModel("https://pbs.twimg.com/profile_images/1356962252780429313/ccjxrCjD_400x400.jpg","123", "Besmart", "**** **** 7054", "14/04/20 06:42", "2373,45 c", "Успешно!", "Пополнение"))
        list.add(HistoryModel("https://pbs.twimg.com/profile_images/1356962252780429313/ccjxrCjD_400x400.jpg","123", "Besmart", "**** **** 7054", "14/04/20 06:42", "2373,45 c", "Успешно!", "Пополнение"))
        list.add(HistoryModel("https://pbs.twimg.com/profile_images/1356962252780429313/ccjxrCjD_400x400.jpg","123", "Besmart", "**** **** 7054", "14/04/20 06:42", "2373,45 c", "Успешно!", "Пополнение"))
        list.add(HistoryModel("https://pbs.twimg.com/profile_images/1356962252780429313/ccjxrCjD_400x400.jpg","123", "Besmart", "**** **** 7054", "14/04/20 06:42", "2373,45 c", "Успешно!", "Пополнение"))
        list.add(HistoryModel("https://pbs.twimg.com/profile_images/1356962252780429313/ccjxrCjD_400x400.jpg","123", "Besmart", "**** **** 7054", "14/04/20 06:42", "2373,45 c", "Успешно!", "Пополнение"))
        list.add(HistoryModel("https://pbs.twimg.com/profile_images/1356962252780429313/ccjxrCjD_400x400.jpg","123", "Besmart", "**** **** 7054", "14/04/20 06:42", "2373,45 c", "Успешно!", "Пополнение"))
        list.add(HistoryModel("https://pbs.twimg.com/profile_images/1356962252780429313/ccjxrCjD_400x400.jpg","123", "Besmart", "**** **** 7054", "14/04/20 06:42", "2373,45 c", "Успешно!", "Пополнение"))
        list.add(HistoryModel("https://pbs.twimg.com/profile_images/1356962252780429313/ccjxrCjD_400x400.jpg","123", "Besmart", "**** **** 7054", "14/04/20 06:42", "2373,45 c", "Успешно!", "Пополнение"))
        list.add(HistoryModel("https://pbs.twimg.com/profile_images/1356962252780429313/ccjxrCjD_400x400.jpg","123", "Besmart", "**** **** 7054", "14/04/20 06:42", "2373,45 c", "Успешно!", "Пополнение"))
    }

    override fun onItemClick(position: Int) {

    }


    private fun setupRecycler() {
        viewModel.checkList(list)
        adapter = HistoryAdapter(list, this)
        binding!!.historyRecycler.adapter = adapter
        RecyclerAnimation.startAnimation(binding!!.historyRecycler, R.anim.main_recycler_anim_layout)
    }

}