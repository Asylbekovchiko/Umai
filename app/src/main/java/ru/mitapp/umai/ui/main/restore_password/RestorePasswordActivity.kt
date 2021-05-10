package ru.mitapp.umai.ui.main.restore_password

import android.app.Activity
import android.content.Intent
import android.text.Editable
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityRestorePasswordBinding
import ru.mitapp.umai.helper.BaseTextChangeListener
import ru.mitapp.umai.models.auth.Phone
import ru.mitapp.umai.ui.main.pin_code_restore.PinCodeRestoreActivity
import ru.mitapp.umai.utils.REQUEST_PASSWORD_RESTORE

class RestorePasswordActivity
    : BaseActivity<ActivityRestorePasswordBinding>(R.layout.activity_restore_password){

    lateinit var toolbar: Toolbar

    private lateinit var viewModel: RestoreViewModel

    override fun setupView() {

        toolbar = findViewById(R.id.toolbar_restore)
        setSupportActionBar(toolbar)
        toolbar.title = "Восстановление пароля"

        viewModel = ViewModelProvider(this).get(RestoreViewModel::class.java)
        binding!!.viewModel = viewModel
        setInputs()

        password()
        binding!!.loginButton3.setOnClickListener {
            val replacePhone = binding!!.loginInput.text.toString().replace("+", "").replace("(", "")
                .replace(")", "")
                .replace("-", "")
            val phone = Phone(
                replacePhone
            )
            viewModel.restorePassword(phone)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    fun setInputs(){
        binding!!.loginInput.addTextChangedListener(object : BaseTextChangeListener(){
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })
    }

    fun checkInputs(){
        viewModel.checkInputs(binding!!.loginInput.text.toString())
    }

    fun password(){
        viewModel.restorePassword.observe(this, Observer {
            if (it.data != null){
                val intent = Intent(this, PinCodeRestoreActivity::class.java)
                intent.putExtra("phone", binding!!.loginInput.text.toString())
                startActivityForResult(intent, REQUEST_PASSWORD_RESTORE)
            }
        })
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            if (requestCode == REQUEST_PASSWORD_RESTORE) {
                if (data != null) {
                    val intent = Intent()
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
            }
        }
    }
}