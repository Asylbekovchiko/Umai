package ru.mitapp.umai.ui.home.more.settings.activity


import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import ru.mitapp.umai.AppUmai.Companion.sharedPreferences
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityLanguagesBinding

class LanguagesActivity: BaseActivity<ActivityLanguagesBinding>(R.layout.activity_languages) {
    lateinit var toolbar: Toolbar

    override fun setupView() {
        setupToolbar()

        when(sharedPreferences.language){
            "ru" -> binding.russianButton.isChecked = true
            "kg" -> binding.kyrgyzButton.isChecked = true
            "en" -> binding.englishButton.isChecked = true
        }

        binding.russianButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                sharedPreferences.language = "ru"
            }
        }

        binding.kyrgyzButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                sharedPreferences.language = "kg"
            }
        }

        binding.englishButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                sharedPreferences.language = "en"
            }
        }



    }

    private fun setupToolbar(){
        toolbar = findViewById(R.id.toolbarLanguage)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            onBackPressed()
        }
        return true
    }
}
