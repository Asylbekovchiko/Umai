package ru.mitapp.umai.ui.home.more.partners.activity

import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityDetailPartnersBinding
import ru.mitapp.umai.utils.BEELINE_TITLE
import ru.mitapp.umai.utils.KICB_TITLE


class DetailPartnersActivity : BaseActivity<ActivityDetailPartnersBinding>(R.layout.activity_detail_partners) {


    private val title :String?
    get()= intent.getStringExtra("title")


    private val description: String?
    get() = intent.getStringExtra("description")



    override fun setupView() {

        fileListAdd()
    }

    private fun fileListAdd(){


        binding!!.partnersTitle.text = title
        binding!!.partnersDescription.text = description

    }

}