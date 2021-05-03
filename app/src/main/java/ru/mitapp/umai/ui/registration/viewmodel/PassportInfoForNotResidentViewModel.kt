package ru.mitapp.umai.ui.registration.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class PassportInfoForNotResidentViewModel : ViewModel() {

    var isButtonActive = ObservableField(false)


    fun checkInputs(documentName: String?, passportNumber: String?, pin: String?,
                    dateIssue: String?, expirationDate: String?, whoIssued: String?) {

        if(!documentName.isNullOrEmpty() && !passportNumber.isNullOrEmpty() && !pin.isNullOrEmpty()
            && !dateIssue.isNullOrEmpty() && !expirationDate.isNullOrEmpty() &&  !whoIssued.isNullOrEmpty()){
            isButtonActive.set(true)
        }else{
            isButtonActive.set(false)
        }

    }

}