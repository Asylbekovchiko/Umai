package ru.mitapp.umai.ui.registration.fragment

import android.text.Editable
import androidx.lifecycle.ViewModelProviders
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.UserEmailFragmentBinding
import ru.mitapp.umai.helper.BaseTextChangeListener
import ru.mitapp.umai.ui.registration.listener.IdentificationListener
import ru.mitapp.umai.ui.registration.viewmodel.UserEmailViewModel

class UserEmailFragment(var listener: IdentificationListener) : BaseFragment<UserEmailFragmentBinding>(R.layout.user_email_fragment) {

    private lateinit var viewModel: UserEmailViewModel

    override fun setupView() {
        viewModel = ViewModelProviders.of(this).get(UserEmailViewModel::class.java)

        binding!!.viewModel = viewModel
        setUpInputs()
    }

    fun setUpInputs(){
        binding!!.secretWordInput.addTextChangedListener(object : BaseTextChangeListener(){
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })

        binding!!.houseInput.addTextChangedListener(object : BaseTextChangeListener(){
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })
    }

    fun checkInputs(){
        viewModel.checkInputs(binding!!.secretWordInput.text.toString(),
        binding!!.houseInput.text.toString())
    }

}