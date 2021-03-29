package ru.mitapp.umai.ui.home.service.fragment


import android.content.Intent
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.FragmentServiceBinding
import ru.mitapp.umai.extension.showToast
import ru.mitapp.umai.models.service.ServiceModel
import ru.mitapp.umai.ui.home.service.activity.SubCategoryActivity
import ru.mitapp.umai.ui.home.service.adapter.ServiceAdapter
import ru.mitapp.umai.utils.RecyclerAnimation
import ru.mitapp.umai.utils.TITLE
import java.util.ArrayList

class ServiceFragment : BaseFragment<FragmentServiceBinding>(R.layout.fragment_service),
    ServiceAdapter.Listener {
    private lateinit var adapter: ServiceAdapter
    var list = ArrayList<ServiceModel>()

    override fun setupView() {

        binding!!.refreshLayout.setOnRefreshListener {
            setupRecycler()
            binding!!.refreshLayout.isRefreshing = false
        }

        fillList()
        setupRecycler()

    }

    private fun setupRecycler() {
        adapter = ServiceAdapter(list, this)
        binding!!.serviceRecyclerView.adapter = adapter
        RecyclerAnimation.startAnimation(binding!!.serviceRecyclerView, R.anim.main_recycler_anim_layout)
    }



    private fun fillList() {
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
    }

    override fun onItemClick(serviceModel: ServiceModel) {
        val intent = Intent(requireContext(), SubCategoryActivity::class.java)
        intent.putExtra(TITLE, serviceModel.title)
        startActivity(intent)
    }

}