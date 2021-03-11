package ru.mitapp.umai.ui.registration.activity


import android.content.Intent
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityRegistrationStartBinding

class RegistrationStartActivity :
    BaseActivity<ActivityRegistrationStartBinding>(R.layout.activity_registration_start) {

    private lateinit var toolbar: Toolbar

    override fun setupView() {
        toolbar = findViewById(R.id.toolbarPartners)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)


        binding.registrationStartButton.setOnClickListener{
            startActivity(Intent(this, UserIdentificationActivity::class.java))
        }

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }

        return super.onOptionsItemSelected(item)

    }

}