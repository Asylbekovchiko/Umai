package ru.mitapp.umai.ui.registration.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.mitapp.umai.AppUmai
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.UserCitizenshipFragmentBinding
import ru.mitapp.umai.ui.registration.listener.IdentificationListener
import ru.mitapp.umai.ui.registration.viewmodel.UserCitizenshipViewModel

class UserCitizenshipFragment(var listener : IdentificationListener) : BaseFragment<UserCitizenshipFragmentBinding>(R.layout.user_citizenship_fragment) {

    private lateinit var viewModel: UserCitizenshipViewModel

    override fun init() {
        viewModel = ViewModelProviders.of(this).get(UserCitizenshipViewModel::class.java)

        binding.radioGroup.setOnCheckedChangeListener{ _,  buttonId ->
            AppUmai.sharedPreferences.isCitizen = buttonId == R.id.citizen_button
        }

        binding.citizenButton.isChecked = AppUmai.sharedPreferences.isCitizen

        binding.nextButton.setOnClickListener{
            listener.onNextButtonClick()
        }

    }

}