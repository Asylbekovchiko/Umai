package ru.mitapp.umai.ui.registration.activity

import android.os.CountDownTimer
import android.text.Editable
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.tools.build.jetifier.core.utils.Log
import ru.mitapp.umai.AppUmai
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivitySmsCodeBinding
import ru.mitapp.umai.extension.showToast
import ru.mitapp.umai.helper.BaseTextChangeListener
import ru.mitapp.umai.models.register.SmsCode
import ru.mitapp.umai.ui.registration.viewmodel.SmsCodeViewModel
import java.text.SimpleDateFormat
import java.util.*


class SmsCodeActivity : BaseActivity<ActivitySmsCodeBinding>(R.layout.activity_sms_code) {

    private lateinit var viewModel: SmsCodeViewModel

    private val phone: String?
        get() = intent.getStringExtra("phone")

    var counter: Long = 20000

    lateinit var toolbar: Toolbar

    override fun setupView() {
        viewModel = ViewModelProvider(this).get(SmsCodeViewModel::class.java)
        binding!!.viewModel = viewModel

        toolbar = findViewById(R.id.toolbarPartners)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)


        if (phone != null) {
            binding!!.textView19.text = phone
        }

        val replacePhone = phone!!.replace("+", "").replace("(", "")
            .replace(")", "")
            .replace("-", "")


        activateNumber()
        setUpInputs()
        timer()

        binding!!.loginButton.setOnClickListener {
            val smsCode = binding!!.pinEditTetxt.text.toString()
            viewModel.activateUser(replacePhone,
                SmsCode(
                    smsCode
                ), AppUmai.sharedPreferences.token!!
            )
        }

        binding!!.notTrue.setOnClickListener {
            onBackPressed()
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

    fun setUpInputs(){
        binding!!.pinEditTetxt.addTextChangedListener(object : BaseTextChangeListener(){
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })

    }


    fun checkInputs(){
        viewModel.checkInputs(binding!!.pinEditTetxt.text.toString())
    }

    private fun timer(){
        object : CountDownTimer(counter, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding!!.textTimer.text =
                    convertMilsToTime(counter)
                counter -= 1000
            }

            override fun onFinish() {
                counter = 180000
            }
        }.start()
    }
    fun convertMilsToTime(millis: Long): String {
        val simpleDateFormat = SimpleDateFormat("mm:ss")
        return simpleDateFormat.format(Date(millis))
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}