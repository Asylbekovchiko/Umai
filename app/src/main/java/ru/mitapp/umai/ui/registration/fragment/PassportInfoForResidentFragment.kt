package ru.mitapp.umai.ui.registration.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.PassportInfoForResidentFragmentBinding
import ru.mitapp.umai.helper.BaseTextChangeListener
import ru.mitapp.umai.ui.registration.listener.IdentificationListener
import ru.mitapp.umai.ui.registration.viewmodel.PassportInfoForResidentViewModel

class PassportInfoForResidentFragment(var listener : IdentificationListener)
    : BaseFragment<PassportInfoForResidentFragmentBinding>(R.layout.passport_info_for_resident_fragment) {


    private lateinit var viewModel: PassportInfoForResidentViewModel


    override fun setupView() {
        viewModel = ViewModelProviders.of(this).get(PassportInfoForResidentViewModel::class.java)

        binding!!.viewModel = viewModel

        binding!!.nextButton.setOnClickListener{
            listener.onNextButtonClick()
        }

        binding!!.documentNameInput.addTextChangedListener(object : BaseTextChangeListener(){
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })
        binding!!.passportNumberInput.addTextChangedListener(object : BaseTextChangeListener(){
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })
        binding!!.dateIssueInput.addTextChangedListener(object : BaseTextChangeListener(){
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })
        binding!!.expirationDateInput.addTextChangedListener(object : BaseTextChangeListener(){
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })
        binding!!.whoIssuedDocumentInput.addTextChangedListener(object : BaseTextChangeListener(){
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })

    }

    fun checkInputs(){
        viewModel.checkInputs(
            binding!!.documentNameInput.text.toString(), binding!!.passportNumberInput.text.toString(),
            binding!!.dateIssueInput.text.toString(), binding!!.expirationDateInput.text.toString(),
            binding!!.whoIssuedDocumentInput.text.toString()
        )
    }

}