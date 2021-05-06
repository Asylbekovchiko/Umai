package ru.mitapp.umai.ui.main.register

import android.content.Intent
import android.text.Editable
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import ru.mitapp.umai.AppUmai
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityRegisterBinding
import ru.mitapp.umai.extension.showToast
import ru.mitapp.umai.helper.BaseTextChangeListener
import ru.mitapp.umai.models.auth.CreateUser
import ru.mitapp.umai.ui.registration.activity.SmsCodeActivity
import ru.mitapp.umai.ui.web_view.WebViewActivity

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(R.layout.activity_register) {

    private lateinit var viewModel: RegisterViewModel
    private val user = CreateUser()
    lateinit var toolbar: Toolbar
    override fun setupView() {

        toolbar = findViewById(R.id.toolbar_register)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.title = "Регистрация"

        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        binding!!.viewModel = viewModel

        setInputs()


        createUser()
        binding!!.registerButton.setOnClickListener {
            val phone = binding!!.edtPhone.text.toString().trim()
            val name = binding!!.edtName.text.toString().trim()
            val password = binding!!.edtPassword.text.toString().trim()
            setPhone(name, phone, password)
            viewModel.createUser(user)
        }

        binding!!.termsOfUse.setOnClickListener {
            WebViewActivity.start(
                this,
                "https://play.google.com/store/apps/details?id=kg.bmt.uw",
                getString(R.string.terms_of_use)
            )
        }

        binding!!.haveAccount.setOnClickListener {
            onBackPressed()
        }

    }

    private fun setPhone(name: String, phone: String, password: String) {
        val replacePhone = phone.replace("+", "").replace("(", "")
            .replace(")", "")
            .replace("-", "")

        user.name = name
        user.phone = replacePhone
        user.email = null
        user.password = password
        user.noCaptcha = true
    }

    private fun createUser() {

        viewModel.createUser.observe(this, androidx.lifecycle.Observer {
            if (it.data != null) {
                val intent = Intent(this, SmsCodeActivity::class.java)
                intent.putExtra("phone", binding!!.edtPhone.text.toString())
                AppUmai.sharedPreferences.token = it.data!!.token
                startActivity(intent)
            } else if (it.responseCode == 422) {
                if (it.errors?.phone != null) {
                    this.showToast(it.errors?.phone?.message)
                } else {
                    this.showToast(it.errors?.captcha?.message)
                }
            } else {
                this.showToast(it.errorMessage)
            }
        })
    }


    fun setInputs() {
        binding!!.edtName.addTextChangedListener(object : BaseTextChangeListener() {
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })
        binding!!.edtPhone.addTextChangedListener(object : BaseTextChangeListener() {
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })
        binding!!.edtPassword.addTextChangedListener(object : BaseTextChangeListener() {
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })

        binding!!.checkbox.setOnCheckedChangeListener { _, _ ->
            checkInputs()
        }
    }

    fun checkInputs() {
        viewModel.checkInputs(
            binding!!.edtName.text.toString().trim(),
            binding!!.edtPhone.text.toString().trim(),
            binding!!.edtPassword.text.toString().trim(),
            binding!!.checkbox.isChecked
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}