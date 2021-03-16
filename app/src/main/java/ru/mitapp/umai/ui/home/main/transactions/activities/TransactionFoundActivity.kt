package ru.mitapp.umai.ui.home.main.transactions.activities

import android.app.Activity
import android.content.Intent
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityTransactionFoundBinding
import ru.mitapp.umai.utils.REQUEST_CODE

class TransactionFoundActivity : BaseActivity<ActivityTransactionFoundBinding>(R.layout.activity_transaction_found){
    override fun setupView() {
        setSupportActionBar(binding.foundToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.payButton.setOnClickListener {
            val intent = Intent(this, TransactionSuccessActivity::class.java)
            startActivityForResult(intent,  REQUEST_CODE)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            if (requestCode == REQUEST_CODE) {
                if (data != null) {
                    val intent = Intent()
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
            }

        }
    }
}