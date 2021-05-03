package ru.mitapp.umai.ui.registration.viewmodel

import androidx.databinding.ObservableField
import ru.mitapp.umai.base.BaseViewModel

class UserAddressResidentViewModel : BaseViewModel() {

    var isButtonActive = ObservableField(false)


    fun checkInputs(regionSpinner: String?, districtSpinner: String?,
                    citySpinner: String?, streetInput: String?, houseInput: String?,
                    apartmentInput: String?, addressCb: Boolean?
    ) {

        if(!regionSpinner.isNullOrEmpty() && !districtSpinner.isNullOrEmpty()
            && !citySpinner.isNullOrEmpty() && !streetInput.isNullOrEmpty() &&  !houseInput.isNullOrEmpty()
           && !apartmentInput.isNullOrEmpty() &&  addressCb==true
        ){
            isButtonActive.set(true)
        }else{
            isButtonActive.set(false)
        }

    }

}