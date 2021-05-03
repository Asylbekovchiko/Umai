package ru.mitapp.umai.ui.registration.fragment

import android.text.Editable
import androidx.lifecycle.ViewModelProviders
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.PassportInfoForNotResidentFragmentBinding
import ru.mitapp.umai.helper.BaseTextChangeListener
import ru.mitapp.umai.ui.registration.listener.IdentificationListener
import ru.mitapp.umai.ui.registration.viewmodel.PassportInfoForNotResidentViewModel

class PassportInfoForNotResidentFragment(var listener: IdentificationListener) :
    BaseFragment<PassportInfoForNotResidentFragmentBinding>(R.layout.passport_info_for_not_resident_fragment) {


    private lateinit var viewModel: PassportInfoForNotResidentViewModel


    override fun setupView() {
        viewModel = ViewModelProviders.of(this).get(PassportInfoForNotResidentViewModel::class.java)

        binding!!.viewModel = viewModel

        binding!!.nextButton.setOnClickListener {
            listener.onNextButtonClick()
        }

        binding!!.documentNameInput.addTextChangedListener(object : BaseTextChangeListener() {
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })
        binding!!.passportNumberInput.addTextChangedListener(object : BaseTextChangeListener() {
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })
        binding!!.pinInput.addTextChangedListener(object : BaseTextChangeListener() {
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })
        binding!!.dateIssueInput.addTextChangedListener(object : BaseTextChangeListener() {
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })
        binding!!.expirationDateInput.addTextChangedListener(object : BaseTextChangeListener() {
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })
        binding!!.whoIssuedDocumentInput.addTextChangedListener(object : BaseTextChangeListener() {
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })


    }

    fun checkInputs() {
        viewModel.checkInputs(
            binding!!.documentNameInput.text.toString(),
            binding!!.passportNumberInput.text.toString(),
            binding!!.pinInput.text.toString(),
            binding!!.dateIssueInput.text.toString(),
            binding!!.expirationDateInput.text.toString(),
            binding!!.whoIssuedDocumentInput.text.toString()
        )
    }

}