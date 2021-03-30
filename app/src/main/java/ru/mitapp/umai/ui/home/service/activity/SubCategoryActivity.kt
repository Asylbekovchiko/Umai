package ru.mitapp.umai.ui.home.service.activity


import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivitySubCategoryBinding
import ru.mitapp.umai.models.service.SubCategory
import ru.mitapp.umai.ui.home.service.adapter.SubCategoryAdapter
import ru.mitapp.umai.utils.RecyclerAnimation
import ru.mitapp.umai.utils.TITLE

class SubCategoryActivity : BaseActivity<ActivitySubCategoryBinding>(R.layout.activity_sub_category), SubCategoryAdapter.Listener {

    private lateinit var toolbar: Toolbar
    private lateinit var toolbarTitle: TextView

    private val title: String?
        get() = intent.getStringExtra(TITLE)

    var suCategories : ArrayList<SubCategory> = ArrayList()


    override fun setupView() {
        setupToolbar()

        fillSubCategories()
        setupRecycler(suCategories)
    }


    private fun setupRecycler(suCategories : ArrayList<SubCategory>){
        binding!!.categoryRecycler.adapter = SubCategoryAdapter(suCategories, this)
        RecyclerAnimation.startAnimation(binding!!.categoryRecycler, R.anim.main_recycler_anim_layout)
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


    private fun fillSubCategories(){
        suCategories.add(SubCategory("Aknet", "https://www.aknet.kg/ima/aknet.jpg", true))
        suCategories.add(SubCategory("Megaline", "https://megaline.kg/wp-content/themes/megaline/img/logo.png", false))
        suCategories.add(SubCategory("Saima4G", "data:image/png;base64,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", true))
        suCategories.add(SubCategory("Homeline", "data:image/jpeg;base64,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", true))
    }


    override fun onSubCategoryClickListener(subCategory: SubCategory) {

    }


}
