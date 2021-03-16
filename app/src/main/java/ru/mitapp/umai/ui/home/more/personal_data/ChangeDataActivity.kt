package ru.mitapp.umai.ui.home.more.personal_data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityChangeDataBinding


class ChangeDataActivity : BaseActivity<ActivityChangeDataBinding>(R.layout.activity_change_data) {
    private lateinit var toolbar: Toolbar

    private val firstName: String?
        get() = intent.getStringExtra("name_label")

    val nameVar: String?
        get() = intent.getStringExtra("name_var")

    private val secondNameLabel: String?
        get() = intent.getStringExtra("second_name_label")

    val secondNameVar: String?
        get() = intent.getStringExtra("second_name_var")

    private val numberLabel: String?
        get() = intent.getStringExtra("number_label")

    private val emailLabel: String?
        get() = intent.getStringExtra("email_label")

    override fun setupView() {
        addData()
        setToolbar()
    }

    private fun setToolbar() {
        toolbar = findViewById(R.id.change_data_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return true
    }

    private fun addData() {
        if (firstName != null) {
            binding.changingLabel.text = firstName

        } else if (secondNameLabel != null) {
            binding.changingLabel.text = secondNameLabel

        } else if (numberLabel != null) {
            binding.changingLabel.text = numberLabel

        } else if (emailLabel != null) {
            binding.changingLabel.text = emailLabel
        }
    }
    private fun setResult(){

    }
}
