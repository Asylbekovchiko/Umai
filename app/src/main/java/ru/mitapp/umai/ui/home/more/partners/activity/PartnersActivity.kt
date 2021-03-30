package ru.mitapp.umai.ui.home.more.partners.activity

import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityPartnersBinding
import ru.mitapp.umai.models.partner.Partners
import ru.mitapp.umai.ui.home.service.adapter.PartnersAdapter
import ru.mitapp.umai.utils.*
import java.util.ArrayList

class PartnersActivity : BaseActivity<ActivityPartnersBinding>(R.layout.activity_partners),
    PartnersAdapter.Listener {
    private lateinit var toolbar : Toolbar
    private lateinit var toolbarTitle: TextView
    private lateinit var adapter: PartnersAdapter
    private lateinit var userKeyWordInput: String

    var list = ArrayList<Partners>()

    override fun setupView() {




        fillList()
        setupRecyclerS()
        setupToolbar()
    }

    private fun setupToolbar(){
        toolbar = findViewById(R.id.toolbarPartners)
        toolbarTitle = findViewById(R.id.toolbarTitle)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbarTitle.text = "Партнеры"

    }

    private fun setupRecyclerS() {


        adapter = PartnersAdapter(list, this)
        binding!!.recyclerPartners.adapter = adapter
        RecyclerAnimation.startAnimation(
            binding!!.recyclerPartners,
            R.anim.main_recycler_anim_layout
        )


    }




    private fun fillList() {
        list.add(Partners(title = "Билайн", description = "Платежная система"))
        list.add(Partners(title = "KICB Банк", description = "Платежная система"))

        list.add(Partners(title = "Билайн", description = "Платежная система"))
        list.add(Partners(title = "KICB Банк", description = "Платежная система"))

        list.add(Partners(title = "Билайн", description = "Платежная система"))
        list.add(Partners(title = "KICB Банк", description = "Платежная система"))

        list.add(Partners(title = "Билайн", description = "Платежная система"))
        list.add(Partners(title = "KICB Банк", description = "Платежная система"))


    }


    override fun onClick(partners: Partners) {
       val intent = Intent(this, DetailPartnersActivity::class.java)
        intent.putExtra("title", partners.title)
        intent.putExtra("description", partners.description)
        startActivity(intent)


    }

}