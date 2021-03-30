package ru.mitapp.umai.ui.home.more.linked_cards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityLinkedCardsBinding

class LinkedCardsActivity : BaseActivity<ActivityLinkedCardsBinding>(R.layout.activity_linked_cards) {
    private lateinit var toolbar: Toolbar

    override fun setupView() {
    setupToolbar()
        addNewCard()
    }

    private fun setupToolbar(){
        toolbar = findViewById(R.id.toolbar_cards)
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

    private fun addNewCard(){
        binding!!.textAddCard.setOnClickListener {
            val intent = Intent(this, AddingNewCardsActivity::class.java)
            startActivity(intent)
        }
    }
}
