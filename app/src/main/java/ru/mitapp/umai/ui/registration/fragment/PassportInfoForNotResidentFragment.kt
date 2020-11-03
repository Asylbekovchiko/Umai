package ru.mitapp.umai.ui.registration.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.PassportInfoForNotResidentFragmentBinding
import ru.mitapp.umai.databinding.PassportInfoForResidentFragmentBinding
import ru.mitapp.umai.ui.registration.listener.IdentificationListener
import ru.mitapp.umai.ui.registration.viewmodel.PassportInfoForNotResidentViewModel
import ru.mitapp.umai.ui.registration.viewmodel.PassportInfoForResidentViewModel

class PassportInfoForNotResidentFragment(var listener : IdentificationListener)
    : BaseFragment<PassportInfoForNotResidentFragmentBinding>(R.layout.passport_info_for_not_resident_fragment) {


    private lateinit var viewModel: PassportInfoForNotResidentViewModel


    override fun init() {
        viewModel = ViewModelProviders.of(this).get(PassportInfoForNotResidentViewModel::class.java)

        binding.nextButton.setOnClickListener{
            listener.onNextButtonClick()
        }
    }

}