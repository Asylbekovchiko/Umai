package ru.mitapp.umai.ui.home.more.personal_data


import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_personal_data.view.*

import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityPersonalDataBinding

class PersonalDataActivity :
    BaseActivity<ActivityPersonalDataBinding>(R.layout.activity_personal_data) {
    private lateinit var toolbar: Toolbar
    private lateinit var toolbarPersonalData: TextView

    override fun setupView() {
        setupToolbar()

    }

    private fun setupToolbar() {
        toolbar = findViewById(R.id.toolbar_personal_data)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return true

    }


    fun setName(view: View) {
        val intentName = Intent(this, ChangeDataActivity::class.java)
        intentName.putExtra("name_label",view.name_label.text)
//        intent.putExtra("name_var", binding.varName.text)
        startActivity(intentName)

    }

    fun setSecondName(view: View) {
        val intent = Intent(this, ChangeDataActivity::class.java)
         intent.putExtra("second_name_label",view.second_name_label.text)
         intent.putExtra("second_name_var", view.var_second_name.text)
        startActivity(intent)



    }

    fun setNumber(view: View) {
            val intent = Intent(this, ChangeDataActivity::class.java)
            intent.putExtra("number_label",view.number.text)
       intent.putExtra("number_var", view.var_number.text)
        startActivity(intent)

    }

    fun setEmail(view: View) {
            val intent = Intent(this, ChangeDataActivity::class.java)
            intent.putExtra("email_label",view.email.text)
          intent.putExtra("email_var", view.var_email.text)
        startActivity(intent)
    }

    fun setLocation(view: View) {
        val intent = Intent(this, ChangeDataActivity::class.java).apply {

        }

        startActivity(intent)

    }
    class MyDialogFragment : DialogFragment() {

        private val optionsForPhoto = arrayOf("Галерея", "Сделать снимок")

        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            return activity?.let {
                val builder = AlertDialog.Builder(it)
                builder.setTitle("Выберите способ :")
                    .setItems(optionsForPhoto
                    ) { dialog, which ->
                       println("aaaaaaaaaaaaaaa")
                        }
                builder.create()
            } ?: throw IllegalStateException("Activity cannot be null")
        }
    }


}


