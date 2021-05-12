package ru.mitapp.umai.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import ru.mitapp.umai.R
import ru.mitapp.umai.extension.showToast

abstract class BaseFragment<DataBinding : ViewDataBinding>(private val layoutId: Int) : Fragment() {

    lateinit var binding: DataBinding
    var connection = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    protected abstract fun setupView()

    fun checkInternet(click: ()->Unit){
        if (connection){
            click()
        }else{
            showToast(getString(R.string.check_internet))
        }
    }

}

