package ru.mitapp.umai.ui.registration.viewmodel

import androidx.databinding.ObservableField
import ru.mitapp.umai.base.BaseViewModel

class UserEmailViewModel : BaseViewModel() {

    var isButtonActive = ObservableField(false)

    fun checkInputs(secretWordInput: String?, houseInput: String?) {

        if(!secretWordInput.isNullOrEmpty() && !houseInput.isNullOrEmpty()){
            isButtonActive.set(true)
        }else{
            isButtonActive.set(false)
        }

    }

}