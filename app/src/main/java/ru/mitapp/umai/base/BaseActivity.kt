package ru.mitapp.umai.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import ru.mitapp.umai.AppUmai
import ru.mitapp.umai.R

abstract class BaseActivity<DataBinding : ViewDataBinding>(private val layoutId : Int) : AppCompatActivity(){

    protected lateinit var binding : DataBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
       /* getAppTheme(AppUmai.sharedPreferences.theme)*/
        init()


    }

    private fun getAppTheme(theme: String?) {
        when (theme) {
            "light" -> setTheme(R.style.LightTheme)
            "dark" -> setTheme(R.style.DarkTheme)
        }
    }
    abstract fun init()
}