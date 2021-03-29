package ru.mitapp.umai.ui

import android.content.Intent
import android.os.Handler
import android.view.WindowManager
import ru.mitapp.umai.AppUmai.Companion.sharedPreferences
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityStartBinding
import ru.mitapp.umai.ui.home.HomeActivity

class StartActivity : BaseActivity<ActivityStartBinding>(R.layout.activity_start) {

    override fun setupView() {

        getAppTheme(sharedPreferences.isDarkThem)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        Handler().postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()


        }, 2000)
    }
}