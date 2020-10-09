package ru.mitapp.umai.ui

import android.content.Intent
import android.os.Handler
import android.view.WindowManager
import ru.mitapp.umai.ui.main.activity.MainActivity
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityStartBinding

class StartActivity : BaseActivity<ActivityStartBinding>(R.layout.activity_start) {

    override fun init() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()


        }, 2000)
    }
}