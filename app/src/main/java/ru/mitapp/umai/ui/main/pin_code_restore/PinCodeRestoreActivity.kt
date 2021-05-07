package ru.mitapp.umai.ui.main.pin_code_restore

import android.text.Editable
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityPinCodeRestoreBinding
import ru.mitapp.umai.helper.BaseTextChangeListener

class PinCodeRestoreActivity : BaseActivity<ActivityPinCodeRestoreBinding>(R.layout.activity_pin_code_restore){

    private val phone: String?
        get() = intent.getStringExtra("phone")

    private lateinit var toolbar: Toolbar

    private lateinit var viewModel: PinRestoreViewModel

    override fun setupView() {
        toolbar = findViewById(R.id.toolbarPartners)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        viewModel = ViewModelProvider(this).get(PinRestoreViewModel::class.java)
        binding!!.viewModel = viewModel

        if (phone != null) {
            binding!!.textView19.text = phone
        }
        setUpInputs()

    }

    fun setUpInputs() {
        binding!!.pinEditTetxt.addTextChangedListener(object : BaseTextChangeListener() {
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })

    }


    fun checkInputs() {
        viewModel.checkInputs(binding!!.pinEditTetxt.text.toString())
    }

}