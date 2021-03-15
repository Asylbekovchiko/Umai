package ru.mitapp.umai.ui.home.main.transactions.activities

import android.content.Intent
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityTransactionFoundBinding

class TransactionFoundActivity : BaseActivity<ActivityTransactionFoundBinding>(R.layout.activity_transaction_found){
    override fun setupView() {
        setSupportActionBar(binding.foundToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.payButton.setOnClickListener {
            val intent = Intent(this, TransactionSuccessActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}