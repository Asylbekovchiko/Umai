package ru.mitapp.umai.ui.home.main.templates.activity.createtemplates

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.mitapp.umai.AppUmai
import ru.mitapp.umai.AppUmai.Companion.context
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityCreateTemplatesBinding
import ru.mitapp.umai.extension.showToast
import ru.mitapp.umai.ui.home.main.templates.activity.chooseservices.ChooseServicesActivity

class CreateTemplatesActivity
    : BaseActivity<ActivityCreateTemplatesBinding>(R.layout.activity_create_templates) {
    override fun setupView() {
        setSupportActionBar(binding.createTempToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val title: String = intent.getStringExtra("text_title").toString()
        if (title != "null"){
            binding.txtChooseService.text = title
        }

        binding.txtChooseService.setOnClickListener {
            val intent = Intent(this@CreateTemplatesActivity, ChooseServicesActivity::class.java)
            startActivity(intent)
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}