package ru.mitapp.umai.ui.home.main.templates.activity.chooseservices

import android.content.Intent
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityChooseServicesBinding
import ru.mitapp.umai.ui.home.main.templates.activity.secondservice.SecondServiceActivity
import ru.mitapp.umai.ui.home.main.templates.adapter.ChooseServiceAdapter
import ru.mitapp.umai.ui.home.main.templates.model.ChooseServiceModel
import ru.mitapp.umai.utils.RecyclerAnimation

class ChooseServicesActivity
    : BaseActivity<ActivityChooseServicesBinding>(R.layout.activity_choose_services), ChooseServiceAdapter.Listener{

    private lateinit var adapter: ChooseServiceAdapter
    private var list = ArrayList<ChooseServiceModel>()

    override fun setupView() {
        setSupportActionBar(binding.chooseServiceToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setupRecycler()
        fillList()
    }

    private fun setupRecycler() {
        adapter = ChooseServiceAdapter(list, this)
        binding.chooseRecyclerService.adapter = adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this@ChooseServicesActivity, SecondServiceActivity::class.java)
        intent.putExtra("title",list[position].title)
        startActivity(intent)
    }
    private fun fillList() {
        list.add(ChooseServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ChooseServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ChooseServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Комунальные услуги"))
        list.add(ChooseServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ChooseServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ChooseServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Комунальные услуги"))
        list.add(ChooseServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Сотовая связь"))
        list.add(ChooseServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Интернет"))
        list.add(ChooseServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Комунальные услуги"))
    }
}