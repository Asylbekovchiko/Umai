package ru.mitapp.umai.ui.home.main.templates.activity.secondservice

import android.content.Intent
import ru.mitapp.umai.AppUmai
import ru.mitapp.umai.AppUmai.Companion.context
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivitySecondCategoryBinding
import ru.mitapp.umai.extension.showToast
import ru.mitapp.umai.ui.home.main.templates.activity.createtemplates.CreateTemplatesActivity
import ru.mitapp.umai.ui.home.main.templates.adapter.ChooseServiceAdapter
import ru.mitapp.umai.ui.home.main.templates.adapter.SecondServiceAdapter
import ru.mitapp.umai.ui.home.main.templates.model.ChooseServiceModel
import ru.mitapp.umai.ui.home.main.templates.model.SecondServiceModel
import ru.mitapp.umai.utils.RecyclerAnimation

class SecondServiceActivity
    : BaseActivity<ActivitySecondCategoryBinding>(R.layout.activity_second_category), SecondServiceAdapter.Listener{
    private lateinit var adapter: SecondServiceAdapter
    private var list = ArrayList<SecondServiceModel>()
    override fun setupView() {
        setSupportActionBar(binding.secondServiceToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val title: String = intent.getStringExtra("title").toString()
        binding.secondTxtService.text = title

        setupRecycler()
        fillList()

    }

    private fun setupRecycler() {
        adapter = SecondServiceAdapter(list, this)
        binding.secondRecyclerService.adapter = adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this@SecondServiceActivity, CreateTemplatesActivity::class.java)
        intent.putExtra("text_title",list[position].title)
        startActivity(intent)
        finish()
    }
    private fun fillList() {
        list.add(SecondServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(SecondServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Unilink"))
        list.add(SecondServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Homline"))

    }
}