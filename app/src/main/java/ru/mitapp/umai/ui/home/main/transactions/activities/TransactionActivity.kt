package ru.mitapp.umai.ui.home.main.transactions.activities

import android.app.Activity
import android.content.Intent
import android.text.Editable
import androidx.lifecycle.ViewModelProvider
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityTransactionBinding
import ru.mitapp.umai.helper.BaseTextChangeListener
import ru.mitapp.umai.ui.home.main.templates.viewmodel.CreateTemplatesViewModel
import ru.mitapp.umai.ui.home.main.transactions.viewmodel.TransactionViewModel
import ru.mitapp.umai.utils.REQUEST_CODE
import ru.mitapp.umai.utils.SERVICE_REQUEST_CODE
import ru.mitapp.umai.utils.TITLE_TEXT

class TransactionActivity : BaseActivity<ActivityTransactionBinding>(R.layout.activity_transaction){

    var viewModel: TransactionViewModel? = null

    override fun setupView() {
        setSupportActionBar(binding!!.transactionToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        if (viewModel == null) {
            viewModel = ViewModelProvider(this)[TransactionViewModel::class.java]
            binding!!.viewModel = viewModel

            binding!!.edtSum.addTextChangedListener(object : BaseTextChangeListener() {
                override fun afterTextChanged(p1: Editable?) {
                    checkButtonActive()
                }
            })
            binding!!.edtPersonal.addTextChangedListener(object : BaseTextChangeListener() {
                override fun afterTextChanged(p1: Editable?) {
                    checkButtonActive()
                }
            })
            binding!!.buttonNext.setOnClickListener {
                val intent = Intent(this, TransactionFoundActivity::class.java)
                startActivityForResult(intent, REQUEST_CODE)
            }

        }

    }

    private fun checkButtonActive() {
        viewModel!!.checkInputs(binding!!.edtPersonal.text.toString(), binding!!.edtSum.text.toString())
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