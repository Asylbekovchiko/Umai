package ru.mitapp.umai.ui.home.more.linked_cards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityAddingNewCardsBinding

class AddingNewCardsActivity : BaseActivity<ActivityAddingNewCardsBinding>(R.layout.activity_adding_new_cards) {

    private lateinit var toolbar: Toolbar

    override fun setupView() {
    setupToolbar()
    }

    private fun setupToolbar(){
        toolbar = findViewById(R.id.toolbar_add_cards)
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
