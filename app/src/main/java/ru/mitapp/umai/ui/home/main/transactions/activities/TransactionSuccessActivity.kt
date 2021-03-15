package ru.mitapp.umai.ui.home.main.transactions.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityTransactionSuccessBinding
import ru.mitapp.umai.ui.home.HomeActivity

class TransactionSuccessActivity : BaseActivity<ActivityTransactionSuccessBinding>(R.layout.activity_transaction_success) {
    override fun setupView() {
        setSupportActionBar(binding.successToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.buttonClose.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            finish()
            startActivity(intent)
        }
        binding.textRepeat.setOnClickListener{
            onSupportNavigateUp()
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}