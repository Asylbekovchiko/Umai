package ru.mitapp.umai.ui.home.service.fragment


import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.FragmentServiceBinding
import ru.mitapp.umai.extension.showToast
import ru.mitapp.umai.models.service_model.ServiceModel
import ru.mitapp.umai.ui.home.service.adapter.ServiceAdapter
import java.util.ArrayList

class ServiceFragment : BaseFragment<FragmentServiceBinding>(R.layout.fragment_service),
    ServiceAdapter.Listener {
    private lateinit var adapter: ServiceAdapter
    var list = ArrayList<ServiceModel>()

    override fun setupView() {

        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))


        adapter =
            ServiceAdapter(
                list,
                this
            )
        binding.serviceRecyclerView.isNestedScrollingEnabled = false
        binding.serviceRecyclerView.adapter = adapter


    }

    override fun onItemClick(position: Int) {
        context?.showToast(position.toString())
    }

}