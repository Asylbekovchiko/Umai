package ru.mitapp.umai.ui.home.more.fragment


import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.FragmentMoreBinding


class MoreFragment : BaseFragment<FragmentMoreBinding>(R.layout.fragment_more) {
    override fun setupView() {

        binding.refreshLayout.setOnRefreshListener {
            binding.refreshLayout.isRefreshing = false
        }
    }
}