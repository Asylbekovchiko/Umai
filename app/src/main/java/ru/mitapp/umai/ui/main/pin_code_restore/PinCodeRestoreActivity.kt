package ru.mitapp.umai.ui.main.pin_code_restore

import android.content.Intent
import android.text.Editable
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityPinCodeRestoreBinding
import ru.mitapp.umai.extension.showToast
import ru.mitapp.umai.helper.BaseTextChangeListener
import ru.mitapp.umai.models.auth.PinCode
import ru.mitapp.umai.ui.main.activity.NewPasswordActivity

class PinCodeRestoreActivity :
    BaseActivity<ActivityPinCodeRestoreBinding>(R.layout.activity_pin_code_restore) {

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


        checkPin()
        setUpInputs()

        binding!!.loginButton.setOnClickListener {
            viewModel.checkPinCode(PinCode(binding!!.pinEditTetxt.text.toString().trim()))
        }


    }

    private fun checkPin() {
        viewModel.checkPinCode.observe(this, Observer {

            val intent = Intent(this, NewPasswordActivity::class.java)

            intent.putExtra("pinCode", binding!!.pinEditTetxt.text.toString())
            startActivity(intent)
            showToast(it.errorMessage.toString())

        })
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

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}