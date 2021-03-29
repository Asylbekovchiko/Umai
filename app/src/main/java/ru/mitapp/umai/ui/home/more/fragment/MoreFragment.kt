package ru.mitapp.umai.ui.home.more.fragment


import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import ru.mitapp.umai.AppUmai.Companion.sharedPreferences
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.FragmentMoreBinding
import ru.mitapp.umai.ui.StartActivity
import ru.mitapp.umai.ui.home.more.viewmodel.MoreViewModel


class MoreFragment : BaseFragment<FragmentMoreBinding>(R.layout.fragment_more) {

    var viewModel : MoreViewModel? = null

    override fun setupView() {
        if (viewModel == null){
            viewModel = ViewModelProvider(this)[MoreViewModel::class.java]

            binding!!.viewModel = viewModel

            binding!!.refreshLayout.setOnRefreshListener {
                binding!!.refreshLayout.isRefreshing = false
            }

            binding!!.darkThemeSwitch.setOnCheckedChangeListener{_ , isChecked ->
                sharedPreferences.isDarkThem = isChecked

            }

            binding!!.darkThemeSwitch.setOnClickListener{
                val intent = Intent(requireContext(), StartActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                requireActivity().finish()
            }

        }

    }
}