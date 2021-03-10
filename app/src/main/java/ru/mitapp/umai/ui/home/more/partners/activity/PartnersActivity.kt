package ru.mitapp.umai.ui.home.more.partners.activity
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.ActivityPartnersBinding
import ru.mitapp.umai.extension.showToast
import ru.mitapp.umai.models.partner.Partners
import ru.mitapp.umai.ui.home.service.adapter.PartnersAdapter
import ru.mitapp.umai.utils.RecyclerAnimation
import java.util.ArrayList

class PartnersActivity : BaseActivity<ActivityPartnersBinding>(R.layout.activity_partners),
    PartnersAdapter.Listener {
    private lateinit var adapter: PartnersAdapter
    var list = ArrayList<Partners>()

    override fun setupView() {


        fillList()
        setupRecyclerS()

    }

    private fun setupRecyclerS() {
        adapter = PartnersAdapter(list, this)
        binding.recyclerPartners.adapter = adapter
        RecyclerAnimation.startAnimation(binding!!.recyclerPartners, R.anim.main_recycler_anim_layout)
    }



    private fun fillList() {

    }

    override fun onItemClick(position: Int) {
        showToast(position.toString())
    }

}