package ru.mitapp.umai.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<DataBinding : ViewDataBinding>(private val layoutId : Int) : AppCompatActivity(){

    protected lateinit var binding : DataBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)

        init()
    }

    abstract fun init()
}