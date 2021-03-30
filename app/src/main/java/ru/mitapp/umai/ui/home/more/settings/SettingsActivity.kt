package ru.mitapp.umai.ui.home.more.settings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import androidx.appcompat.widget.Toolbar
import ru.mitapp.umai.databinding.ActivitySettingBinding
import ru.mitapp.umai.databinding.ActivitySettingBindingImpl
import ru.mitapp.umai.ui.home.more.settings.activity.AboutAppActivity
import ru.mitapp.umai.ui.home.more.settings.activity.LanguagesActivity

class SettingsActivity : BaseActivity<ActivitySettingBinding>(R.layout.activity_setting) {
    private lateinit var toolbar: Toolbar
    private lateinit var toolbarTitle: TextView

    override fun setupView() {
       onClickSettingsItem()

    }

    private fun setupToolbar(){
        toolbar = findViewById(R.id.toolSettings)
        toolbarTitle = findViewById(R.id.toolbarTitle)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbarTitle.text = "Настройки"

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            onBackPressed()
        }
        return true
    }

    private fun onClickSettingsItem(){
        binding!!.language.setOnClickListener {
            val intent = Intent(this, LanguagesActivity::class.java)
            startActivity(intent)
        }
        setupToolbar()

        binding!!.aboutApp.setOnClickListener {
            val intent = Intent(this, AboutAppActivity::class.java)
            startActivity(intent)
        }
    }
}
