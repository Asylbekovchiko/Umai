package ru.mitapp.umai.ui.home.main.templates.activity.secondservice

import android.content.Intent
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivitySecondCategoryBinding
import ru.mitapp.umai.ui.home.main.templates.adapter.SecondServiceAdapter
import ru.mitapp.umai.models.templates_models.SecondServiceModel
import ru.mitapp.umai.utils.TITLE_TEXT

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
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onItemClick(position: Int) {
        val intent = Intent()
        intent.putExtra(TITLE_TEXT, list[position].title)
        setResult(RESULT_OK, intent)
        finish()
    }

    private fun fillList() {
        list.add(SecondServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(SecondServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Unilink"))
        list.add(SecondServiceModel("https://i.ibb.co/PtbSWSM/iphone.png", "Homline"))
    }
}