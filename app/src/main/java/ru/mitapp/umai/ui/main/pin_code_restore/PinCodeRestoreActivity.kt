package ru.mitapp.umai.ui.main.pin_code_restore

import android.app.Activity
import android.content.Intent
import android.text.Editable
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.mitapp.umai.AppUmai.Companion.repository
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityPinCodeRestoreBinding
import ru.mitapp.umai.extension.showToast
import ru.mitapp.umai.helper.BaseTextChangeListener
import ru.mitapp.umai.models.auth.PinCode
import ru.mitapp.umai.ui.main.activity.NewPasswordActivity
import ru.mitapp.umai.utils.REQUEST_PASSWORD_RESTORE

class PinCodeRestoreActivity :
    BaseActivity<ActivityPinCodeRestoreBinding>(R.layout.activity_pin_code_restore) {

    private val phone: String?
        get() = intent.getStringExtra("phone")

    private lateinit var toolbar: Toolbar

    private lateinit var viewModel: PinRestoreViewModel

    override fun setupView() {
        toolbar = findViewById(R.id.toolbar_pin_code)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        viewModel = ViewModelProvider(this).get(PinRestoreViewModel::class.java)
        binding!!.viewModel = viewModel

        if (phone != null) {
            binding!!.textPhone.text = phone
        }


        checkPin()
        setUpInputs()

        binding!!.loginButton.setOnClickListener {
            viewModel.checkPinCode(PinCode(binding!!.pinEditTetxt.text.toString().trim()))
        }


    }

    private fun checkPin() {
        viewModel.checkPinCode.observe(this, Observer { success ->

            if (success==true) {
                val intent = Intent(this, NewPasswordActivity::class.java)
                intent.putExtra("pinCode", binding!!.pinEditTetxt.text.toString())
                startActivityForResult(intent, REQUEST_PASSWORD_RESTORE)
            }else if (success==false){
                showToast("Введён неправильный код для восстановления пароля")
            }

        })
    }


    private fun setUpInputs() {
        binding!!.pinEditTetxt.addTextChangedListener(object : BaseTextChangeListener() {
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            if (requestCode == REQUEST_PASSWORD_RESTORE) {
                if (data != null) {
                    val intent = Intent()
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
            }
        }
    }

    fun checkInputs() {
        viewModel.checkInputs(binding!!.pinEditTetxt.text.toString())
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}