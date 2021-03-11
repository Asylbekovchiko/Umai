package ru.mitapp.umai.ui.home.main.templates.activity.templatesactivity

import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityTemplatesBinding
import ru.mitapp.umai.ui.home.main.templates.activity.createtemplates.CreateTemplatesActivity
import ru.mitapp.umai.ui.home.main.templates.activity.detail.PayTemplatesActivity
import ru.mitapp.umai.ui.home.main.templates.adapter.TemplatesActivityAdapter
import ru.mitapp.umai.models.templates_models.MyTemplatesModel
import ru.mitapp.umai.utils.RecyclerAnimation

class TemplatesActivity
    : BaseActivity<ActivityTemplatesBinding>(R.layout.activity_templates),
TemplatesActivityAdapter.Listener{

    private lateinit var adapter: TemplatesActivityAdapter
    private var list = ArrayList<MyTemplatesModel>()

    override fun setupView() {
        setSupportActionBar(binding.templatesToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        setupRecycler()
        fillList()
    }

    private fun setupRecycler() {
        adapter = TemplatesActivityAdapter(list, this)
        binding.templatesRecyclerView.adapter = adapter
        RecyclerAnimation.startAnimation(binding!!.templatesRecyclerView, R.anim.main_recycler_anim_layout)
    }
    private fun fillList() {
        list.add(MyTemplatesModel("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplatesModel("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplatesModel("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplatesModel("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplatesModel("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplatesModel("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplatesModel("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplatesModel("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplatesModel("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.templates_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.templates_menu_add){
            val intent = Intent(this@TemplatesActivity, CreateTemplatesActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    //При клике переходит в PayTemplatesActivity это детальне активити
    override fun onItemClick(position: Int) {
        val intent = Intent(this@TemplatesActivity, PayTemplatesActivity::class.java)
        startActivityForResult(intent, 2)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}