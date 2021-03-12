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
import ru.mitapp.umai.ui.home.main.templates.activity.edit.EditTemplatesActivity
import ru.mitapp.umai.ui.home.main.templates.viewmodel.CreateTemplatesViewModel
import ru.mitapp.umai.ui.home.main.templates.viewmodel.PayTempViewModel

class PayTemplatesActivity: BaseActivity<ActivityPayTemplatesBinding>(R.layout.activity_pay_templates) {

    var viewModel: PayTempViewModel? = null

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
            val intent = Intent(this@PayTemplatesActivity, EditTemplatesActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}
