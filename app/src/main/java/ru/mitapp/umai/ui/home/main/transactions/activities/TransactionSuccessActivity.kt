package ru.mitapp.umai.ui.home.main.transactions.activities

import android.content.Context
import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityTransactionSuccessBinding
import ru.mitapp.umai.ui.home.history.detail.DetailHistoryActivity
import ru.mitapp.umai.utils.IS_SUCCESS

class TransactionSuccessActivity
    : BaseActivity<ActivityTransactionSuccessBinding>(R.layout.activity_transaction_success) {

    private val isHistory: Boolean
        get() = intent.getBooleanExtra(IS_SUCCESS, false)

    companion object {
        //после isHistory нужно доваить модель (pojo) для того что бы пересылать
        fun startToSuccess(context: Context, isHistory: Boolean = false): Intent {
            val intent = Intent(context, TransactionSuccessActivity::class.java)
            intent.putExtra(IS_SUCCESS, isHistory)
            return intent
        }
    }

    override fun setupView() {
        setSupportActionBar(binding.successToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.isHistory = isHistory
        binding.buttonClose.setOnClickListener {
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.textRepeat.setOnClickListener{
            onSupportNavigateUp()
        }
        binding.txtDetail.setOnClickListener {
            val intent = Intent(this, DetailHistoryActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.share_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.share_menu){

        }
        return super.onOptionsItemSelected(item)
    }
}