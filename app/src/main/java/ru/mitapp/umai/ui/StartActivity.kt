package ru.mitapp.umai.ui

import android.content.Intent
import android.content.res.Configuration
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import ru.mitapp.umai.AppUmai.Companion.sharedPreferences
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityStartBinding
import ru.mitapp.umai.ui.home.HomeActivity
import ru.mitapp.umai.ui.home.service.viewmodel.ServiceViewModel
import ru.mitapp.umai.ui.main.activity.MainActivity
import java.util.*

class StartActivity : BaseActivity<ActivityStartBinding>(R.layout.activity_start) {

    lateinit var viewModel: ServiceViewModel

    override fun setupView() {
        viewModel = ViewModelProvider(this)[ServiceViewModel::class.java]
        binding.viewModel = viewModel
        viewModel.getServices()
        getAppTheme(sharedPreferences.isDarkThem)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        setLocate(sharedPreferences.language!!)

        viewModel.data.observe(this, androidx.lifecycle.Observer {
            if (it.responseCode == 401){
                startActivity(Intent(this, MainActivity::class.java))
            }else{
                startActivity(Intent(this, HomeActivity::class.java))
            }
            finish()
        })

    }

    fun setLocate(lang: String){
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

    }
}