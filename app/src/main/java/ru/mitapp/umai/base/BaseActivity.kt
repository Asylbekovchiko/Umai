package ru.mitapp.umai.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import ru.mitapp.umai.AppUmai.Companion.sharedPreferences
import ru.mitapp.umai.R
import ru.mitapp.umai.extension.showToast

abstract class BaseActivity<DataBinding : ViewDataBinding>(private val layoutId: Int) :
    AppCompatActivity() {

    lateinit var binding: DataBinding
    var connection = true


    override fun onCreate(savedInstanceState: Bundle?) {
        getAppTheme(sharedPreferences.isDarkThem)
        super.onCreate(savedInstanceState)
            binding = DataBindingUtil.setContentView(this, layoutId)
            setupView()




    }

    protected fun getAppTheme(isDarkTheme: Boolean) {
        if (isDarkTheme) {
            setTheme(R.style.DarkTheme)
        } else {
            setTheme(R.style.LightTheme)
        }
    }

    abstract fun setupView()

    fun checkInternet(click: ()->Unit){
        if (connection){
            click()
        }else{
            showToast(getString(R.string.check_internet))
        }
    }

}