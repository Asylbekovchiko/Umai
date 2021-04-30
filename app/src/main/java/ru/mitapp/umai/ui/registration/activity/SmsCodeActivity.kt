package ru.mitapp.umai.ui.registration.activity

import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivitySmsCodeBinding


class SmsCodeActivity : BaseActivity<ActivitySmsCodeBinding>(R.layout.activity_sms_code) {

    val phone: String?
        get() = intent.getStringExtra("phone")

    override fun setupView() {
        if (phone!=null){
            binding!!.textView19.text = phone
        }
    }

}