package ru.mitapp.umai.ui.home.main.templates.activity.chooseservices

import android.app.Activity
import android.content.Intent
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityChooseServicesBinding
import ru.mitapp.umai.ui.home.main.templates.activity.secondservice.SecondServiceActivity
import ru.mitapp.umai.ui.home.main.templates.adapter.ChooseServiceAdapter
import ru.mitapp.umai.models.templates_models.ChooseServiceModel
import ru.mitapp.umai.utils.SERVICE_REQUEST_CODE
import ru.mitapp.umai.utils.SERVICE_TEMPLATE
import ru.mitapp.umai.utils.TITLE_TEXT

class ChooseServicesActivity
    : BaseActivity<ActivityChooseServicesBinding>(R.layout.activity_choose_services), ChooseServiceAdapter.Listener{

    private lateinit var adapter: ChooseServiceAdapter
    private var list = ArrayList<ChooseServiceModel>()

    override fun setupView() {
        setSupportActionBar(binding!!.chooseServiceToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setupRecycler()
        fillList()
    }

    private fun setupRecycler() {
        adapter = ChooseServiceAdapter(list, this)
        binding!!.chooseRecyclerService.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            if (requestCode == SERVICE_REQUEST_CODE) {
                if (data != null) {
                    val titleN: String? = data.getStringExtra(TITLE_TEXT)
                    val intent = Intent()
                    intent.putExtra(TITLE_TEXT, titleN)
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }

            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onItemClick(chooseServiceModel: ChooseServiceModel) {
        val intent = Intent(this@ChooseServicesActivity, SecondServiceActivity::class.java)
        intent.putExtra(TITLE_TEXT, chooseServiceModel.title)
        startActivityForResult(intent, SERVICE_REQUEST_CODE)
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