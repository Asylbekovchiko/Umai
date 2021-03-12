package ru.mitapp.umai.ui.home.more.personal_data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toolbar
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityPersonalDataBinding

class PersonalDataActivity : BaseActivity<ActivityPersonalDataBinding>(R.layout.activity_personal_data) {
    private lateinit var toolbar: Toolbar
    private lateinit var toolbarPersonalData : TextView

    override fun setupView() {
    setupToolbar()
    }

    private fun setupToolbar(){
        toolbar = findViewById(R.id.toolbar_personal_data)
        setActionBar(toolbar)
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

