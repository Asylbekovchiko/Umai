package ru.mitapp.umai.ui.home.more.settings.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityAboutAppBinding

class AboutAppActivity : BaseActivity<ActivityAboutAppBinding>(R.layout.activity_about_app){
    private lateinit var toolbar: Toolbar
    private lateinit var toolbarTitle: TextView

    override fun setupView() {
    setupToolbar()

    }

    private fun setupToolbar(){
        toolbar = findViewById(R.id.toolbar_app_info)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if(item.itemId == android.R.id.home){
        onBackPressed()
    }
        return true
    }
}