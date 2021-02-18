package ru.mitapp.umai.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import ru.mitapp.umai.AppUmai.Companion.sharedPreferences
import ru.mitapp.umai.R

abstract class BaseActivity<DataBinding : ViewDataBinding>(private val layoutId: Int) :
    AppCompatActivity() {

    protected lateinit var binding: DataBinding


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
}