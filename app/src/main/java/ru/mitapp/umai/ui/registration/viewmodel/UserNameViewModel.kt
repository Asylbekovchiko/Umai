package ru.mitapp.umai.ui.registration.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class UserNameViewModel : ViewModel() {


    var isButtonActive = ObservableField(false)


    fun checkInputs(surname: String?, name: String?, middleName: String?, dateBirth: String?) {

        if(!surname.isNullOrEmpty() && !name.isNullOrEmpty()
            && !middleName.isNullOrEmpty() && !dateBirth.isNullOrEmpty()){
            isButtonActive.set(true)
        }else{
            isButtonActive.set(false)
        }

    }

}