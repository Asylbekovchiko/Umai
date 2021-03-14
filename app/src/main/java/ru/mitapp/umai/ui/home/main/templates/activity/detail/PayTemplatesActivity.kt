package ru.mitapp.umai.ui.home.main.templates.activity.detail

import android.content.Intent
import android.text.Editable
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityPayTemplatesBinding
import ru.mitapp.umai.helper.BaseTextChangeListener
import ru.mitapp.umai.models.templates_models.MyTemplate
import ru.mitapp.umai.ui.home.main.templates.activity.createtemplates.CreateTemplatesActivity
import ru.mitapp.umai.ui.home.main.templates.viewmodel.PayTempViewModel
import ru.mitapp.umai.utils.IS_EDIT

class PayTemplatesActivity: BaseActivity<ActivityPayTemplatesBinding>(R.layout.activity_pay_templates) {

    var viewModel: PayTempViewModel? = null

    var myTemplate : MyTemplate =  MyTemplate()

    override fun setupView() {

        if(viewModel == null){

            viewModel = ViewModelProvider(this)[PayTempViewModel::class.java]
            binding.viewModel = viewModel

            setSupportActionBar(binding.payTempToolbar)
            supportActionBar?.setDisplayShowTitleEnabled(false)

            binding.edtSum.addTextChangedListener(object : BaseTextChangeListener() {
                override fun afterTextChanged(p1: Editable?) {
                    checkInputs()
                }
            })
        }


    }

    private fun checkInputs(){
        viewModel!!.checkInputs(binding.edtSum.text.toString())
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.edit_templates_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.edit_templates_menu){
            val intent = CreateTemplatesActivity.start(this, true, myTemplate)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}
