package ru.mitapp.umai.ui.main.activity

import android.text.Editable
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityNewPasswordBinding
import ru.mitapp.umai.helper.BaseTextChangeListener
import ru.mitapp.umai.models.auth.NewPassword
import ru.mitapp.umai.ui.main.view_model.NewPasswordViewModel

class NewPasswordActivity : BaseActivity<ActivityNewPasswordBinding>(R.layout.activity_new_password){

    private lateinit var viewModel: NewPasswordViewModel
    lateinit var toolbar: Toolbar
    private val pinCode: String?
        get() = intent.getStringExtra("pinCode")


    override fun setupView() {

        toolbar = findViewById(R.id.toolbarPartners)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        viewModel = ViewModelProvider(this).get(NewPasswordViewModel::class.java)

        binding!!.viewModel = viewModel

        setUpInputs()

        newPassword()

        binding!!.loginButton.setOnClickListener {
            val newPassword = NewPassword(
                pinCode, binding!!.edtPassword.text.toString().trim(),binding!!.edtPasswordConfirm.text.toString().trim()
            )
            viewModel.newsPassword(newPassword)
        }


    }

    fun newPassword(){
        viewModel.newsPassword.observe(this, Observer {
            setResult(RESULT_OK, intent)
            finish()
        })
    }

    fun setUpInputs() {
        binding!!.edtPassword.addTextChangedListener(object : BaseTextChangeListener() {
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })
        binding!!.edtPasswordConfirm.addTextChangedListener(object : BaseTextChangeListener() {
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })

    }
    fun checkInputs() {
        viewModel.checkInputs(binding!!.edtPassword.text.toString().trim(),binding!!.edtPasswordConfirm.text.toString().trim())
    }
}