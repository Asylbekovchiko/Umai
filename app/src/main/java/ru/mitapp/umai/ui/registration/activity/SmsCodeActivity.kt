package ru.mitapp.umai.ui.registration.activity

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.mitapp.umai.AppUmai
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivitySmsCodeBinding
import ru.mitapp.umai.extension.showToast
import ru.mitapp.umai.models.register.SmsCode
import ru.mitapp.umai.ui.registration.viewmodel.SmsCodeViewModel


class SmsCodeActivity : BaseActivity<ActivitySmsCodeBinding>(R.layout.activity_sms_code) {

    private lateinit var viewModel: SmsCodeViewModel

    private val phone: String?
        get() = intent.getStringExtra("phone")

    override fun setupView() {
        viewModel = ViewModelProvider(this).get(SmsCodeViewModel::class.java)


        if (phone != null) {
            binding!!.textView19.text = phone
        }
        val replacePhone = phone!!.replace("+", "").replace("(", "")
            .replace(")", "")
            .replace("-", "")

        binding!!.viewModel = viewModel


        activateNumber()

        binding!!.loginButton.setOnClickListener {
            val smsCode = binding!!.pinEditTetxt.text.toString()
//            this.showToast(smsCode)
            viewModel.activateUser(replacePhone,
                SmsCode(
                    smsCode
                ), AppUmai.sharedPreferences.token!!
            )
        }

    }

    fun activateNumber() {
        viewModel.smsCode.observe(this, Observer {
            if (it.data != null) {
                this.showToast("Success")
            } else {
                this.showToast(it.error)
            }
        })
    }


}