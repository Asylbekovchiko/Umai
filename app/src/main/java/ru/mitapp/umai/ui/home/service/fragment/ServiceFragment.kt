package ru.mitapp.umai.ui.home.service.fragment


import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.FragmentServiceBinding
import ru.mitapp.umai.models.service.Service
import ru.mitapp.umai.ui.home.service.activity.SubCategoryActivity
import ru.mitapp.umai.ui.home.service.adapter.ServiceAdapter
import ru.mitapp.umai.ui.home.service.viewmodel.ServiceViewModel
import ru.mitapp.umai.utils.RecyclerAnimation
import ru.mitapp.umai.utils.TITLE
import java.util.ArrayList

class ServiceFragment : BaseFragment<FragmentServiceBinding>(R.layout.fragment_service),
    ServiceAdapter.Listener {
    private lateinit var viewModel: ServiceViewModel
    private lateinit var adapter: ServiceAdapter
    var list = ArrayList<Service>()

    override fun setupView() {

        viewModel = ViewModelProvider(this)[ServiceViewModel::class.java]
        adapter = ServiceAdapter(list, this)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setupRecycler()

        viewModel.getServices()

        binding.refreshLayout.setOnRefreshListener {
            viewModel.getServices()
            binding.refreshLayout.isRefreshing = false
        }

        viewModel.data.observe(this, Observer {
            list.addAll(it.data!!)
            adapter.notifyDataSetChanged()
            RecyclerAnimation.startAnimation(binding.serviceRecyclerView, R.anim.main_recycler_anim_layout)
        })


    }

    private fun setupRecycler() {
        binding.serviceRecyclerView.adapter = adapter
        RecyclerAnimation.startAnimation(binding.serviceRecyclerView, R.anim.main_recycler_anim_layout)
    }



    override fun onItemClick(service: Service) {
        val intent = Intent(requireContext(), SubCategoryActivity::class.java)

        //TODO pass id of category
        intent.putExtra(TITLE, service.title?.ru)
        startActivity(intent)
    }

}