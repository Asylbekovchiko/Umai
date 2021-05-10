package ru.mitapp.umai.ui.home.service.activity


import android.content.Intent
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivitySubCategoryServiceBinding
import ru.mitapp.umai.extension.showToast
import ru.mitapp.umai.models.service.SubCategoryService
import ru.mitapp.umai.ui.home.service.adapter.SubCategoryAdapter
import ru.mitapp.umai.ui.home.service.viewmodel.SubCategoryViewModel
import ru.mitapp.umai.ui.home.payment.activity.PaymentActivity
import ru.mitapp.umai.utils.RecyclerAnimation
import ru.mitapp.umai.utils.SERVICE_ID
import ru.mitapp.umai.utils.TITLE
import java.util.ArrayList

class SubCategoryServiceActivity : BaseActivity<ActivitySubCategoryServiceBinding>(R.layout.activity_sub_category_service), SubCategoryAdapter.Listener {

    private lateinit var toolbar: Toolbar
    private lateinit var toolbarTitle: TextView

    private val title: String?
        get() = intent.getStringExtra(TITLE)

    private val id: String?
        get() = intent.getStringExtra(SERVICE_ID)

    var list = ArrayList<SubCategoryService>()
    lateinit var adapter: SubCategoryAdapter

    private lateinit var viewModel: SubCategoryViewModel


    override fun setupView() {
        viewModel = ViewModelProvider(this)[SubCategoryViewModel::class.java]
        binding.viewModel = viewModel
        setupToolbar()
        viewModel.getServices(id!!)
        setupRecycler()
        setUpObserver()
    }


    private fun setupRecycler(){
        adapter = SubCategoryAdapter(list, this)
        binding.categoryRecycler.adapter = adapter
        RecyclerAnimation.startAnimation(binding.categoryRecycler, R.anim.main_recycler_anim_layout)
    }

    private fun setupToolbar() {
        toolbar = findViewById(R.id.toolbar)
        toolbarTitle = findViewById(R.id.toolbar_title)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbarTitle.text = title
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            onBackPressed()
        return true
    }

    fun setUpObserver(){
        viewModel.data.observe(this, Observer {
            if (it.data != null){
                list.addAll(it.data!!)
                adapter.notifyDataSetChanged()
                binding.refreshRecycler.isRefreshing = false
                RecyclerAnimation.startAnimation(binding.categoryRecycler, R.anim.main_recycler_anim_layout)
            }else{
                showToast(it.errorMessage)
            }
        })

        binding.refreshRecycler.setOnRefreshListener {
            list.clear()
            viewModel.getServices(id!!)
        }

    }


    override fun onSubCategoryClickListener(subCategoryService: SubCategoryService) {
        startActivity(Intent(this, PaymentActivity::class.java))
    }


}

