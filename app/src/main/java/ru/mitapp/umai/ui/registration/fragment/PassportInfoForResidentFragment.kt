package ru.mitapp.umai.ui.registration.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.PassportInfoForResidentFragmentBinding
import ru.mitapp.umai.ui.registration.listener.IdentificationListener
import ru.mitapp.umai.ui.registration.viewmodel.PassportInfoForResidentViewModel

class PassportInfoForResidentFragment(var listener : IdentificationListener)
    : BaseFragment<PassportInfoForResidentFragmentBinding>(R.layout.passport_info_for_resident_fragment) {


    private lateinit var viewModel: PassportInfoForResidentViewModel


    override fun setupView() {
        viewModel = ViewModelProviders.of(this).get(PassportInfoForResidentViewModel::class.java)

        binding.nextButton.setOnClickListener{
            listener.onNextButtonClick()
        }
    }

}