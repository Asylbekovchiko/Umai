package ru.mitapp.umai.ui.registration.viewmodel

import androidx.databinding.ObservableField
import ru.mitapp.umai.base.BaseViewModel

class UserAddressNotResidentViewModel : BaseViewModel() {
    var isButtonActive = ObservableField(false)


    fun checkInputs(countrySpinner: String?, regionSpinner: String?,
                    districtSpinner: String?, citySpinner: String?, streetInput: String?,
                    houseInput: String?, apartment_input: String?, addressCb: Boolean?
    ) {

        if(!countrySpinner.isNullOrEmpty() && !regionSpinner.isNullOrEmpty()
            && !districtSpinner.isNullOrEmpty() && !citySpinner.isNullOrEmpty() &&  !streetInput.isNullOrEmpty()
            && !houseInput.isNullOrEmpty()&& !apartment_input.isNullOrEmpty() &&  addressCb==true
        ){
            isButtonActive.set(true)
        }else{
            isButtonActive.set(false)
        }

    }
}