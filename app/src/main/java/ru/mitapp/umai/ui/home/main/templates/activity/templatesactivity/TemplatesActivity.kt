package ru.mitapp.umai.ui.home.main.templates.activity.templatesactivity

import android.app.AlertDialog
import android.content.Intent
import android.view.*
import android.widget.TextView
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityTemplatesBinding
import ru.mitapp.umai.models.templates_models.MyTemplate
import ru.mitapp.umai.ui.home.main.templates.activity.createtemplates.CreateTemplatesActivity
import ru.mitapp.umai.ui.home.main.templates.activity.detail.PayTemplatesActivity
import ru.mitapp.umai.ui.home.main.templates.adapter.TemplatesActivityAdapter
import ru.mitapp.umai.utils.IS_EDIT
import ru.mitapp.umai.utils.RecyclerAnimation
import ru.mitapp.umai.utils.SERVICE_REQUEST_CODE


class TemplatesActivity
    : BaseActivity<ActivityTemplatesBinding>(R.layout.activity_templates),
TemplatesActivityAdapter.Listener{

    private lateinit var adapter: TemplatesActivityAdapter
    private var list = ArrayList<MyTemplate>()

    override fun setupView() {
        setSupportActionBar(binding.templatesToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        setupRecycler()
        fillList()
    }

    private fun setupRecycler() {
        adapter = TemplatesActivityAdapter(list, this)
        binding.templatesRecyclerView.adapter = adapter
        RecyclerAnimation.startAnimation(
            binding.templatesRecyclerView,
            R.anim.main_recycler_anim_layout
        )
    }
    private fun fillList() {
        list.add(MyTemplate("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplate("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplate("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplate("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplate("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplate("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplate("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplate("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplate("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplate("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplate("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplate("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplate("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplate("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplate("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplate("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplate("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
        list.add(MyTemplate("https://i.ibb.co/PtbSWSM/iphone.png", "Aknet"))
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.templates_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.templates_menu_add){
            val intent = CreateTemplatesActivity.start(this, false)//Не работает
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    //При клике переходит в PayTemplatesActivity это детальне активити
    override fun onItemClick(template: MyTemplate) {
        val intent = Intent(this@TemplatesActivity, PayTemplatesActivity::class.java)
        startActivityForResult(intent, SERVICE_REQUEST_CODE)
    }

    override fun onItemMoreClick(template: MyTemplate) {
        basicAlert()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun basicAlert(){
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater

        val dialogLayout = inflater.inflate(R.layout.bottom_alert_dialog, null)
        builder.setView(dialogLayout)

        val editText = dialogLayout.findViewById<TextView>(R.id.txt_edit)
        editText.setOnClickListener {
            val intent = CreateTemplatesActivity.start(this, true)//Не работает
            startActivity(intent)
        }

        val alertDialog = builder.create()
        alertDialog.show()
        alertDialog.window?.setGravity(Gravity.BOTTOM)
        alertDialog.window?.setBackgroundDrawableResource(R.drawable.bottom_circle)

    }
}