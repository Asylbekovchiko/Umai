package ru.mitapp.umai.ui.home.main.templates.activity.createtemplates

import android.app.Activity
import android.content.Intent
import android.text.Editable
import androidx.lifecycle.ViewModelProvider
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityCreateTemplatesBinding
import ru.mitapp.umai.helper.BaseTextChangeListener
import ru.mitapp.umai.ui.home.main.templates.activity.chooseservices.ChooseServicesActivity
import ru.mitapp.umai.ui.home.main.templates.activity.templatesactivity.TemplatesActivity
import ru.mitapp.umai.ui.home.main.templates.viewmodel.CreateTemplatesViewModel
import ru.mitapp.umai.utils.SERVICE_REQUEST_CODE
import ru.mitapp.umai.utils.TITLE_TEXT

class CreateTemplatesActivity
    : BaseActivity<ActivityCreateTemplatesBinding>(R.layout.activity_create_templates) {

    var viewModel: CreateTemplatesViewModel? = null
    var title: String? = null
    override fun setupView() {
        if (viewModel == null) {
            viewModel = ViewModelProvider(this)[CreateTemplatesViewModel::class.java]
            binding.viewModel = viewModel

            setSupportActionBar(binding.createTempToolbar)
            supportActionBar?.setDisplayShowTitleEnabled(false)

            binding.nameEt.addTextChangedListener(object : BaseTextChangeListener() {
                override fun afterTextChanged(p1: Editable?) {
                    checkButtonActive()
                }
            })
            binding.edtSum.addTextChangedListener(object : BaseTextChangeListener() {
                override fun afterTextChanged(p1: Editable?) {
                    checkButtonActive()
                }
            })
            binding.edtPersonal.addTextChangedListener(object : BaseTextChangeListener() {
                override fun afterTextChanged(p1: Editable?) {
                    checkButtonActive()
                }
            })

            binding.txtChooseService.setOnClickListener {
                val intent = Intent(this@CreateTemplatesActivity, ChooseServicesActivity::class.java)
                startActivityForResult(intent, SERVICE_REQUEST_CODE)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            when(requestCode){
                SERVICE_REQUEST_CODE -> {
                    if (data != null){
                        title = data.getStringExtra(TITLE_TEXT)
                        binding.txtChooseService.text = title
                        checkButtonActive()
                    }

                }
            }
        }

    }

    private fun checkButtonActive(){
        viewModel!!.checkInputs(binding.nameEt.text.toString(), title,
            binding.edtPersonal.text.toString(), binding.edtSum.text.toString())

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}