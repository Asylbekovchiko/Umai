package ru.mitapp.umai.ui.home.main.templates.viewmodel

import androidx.databinding.ObservableField
import ru.mitapp.umai.base.BaseViewModel

class CreateTemplatesViewModel: BaseViewModel() {

    var isButtonActive = ObservableField(false)
    var isNameActive = ObservableField(false)
    var isChooseActive = ObservableField(false)
    var isPersonalActive = ObservableField(false)

    fun checkInputs(name : String?, service: String?, account: String?, sum: String?){
        if (!name.isNullOrEmpty() && !service.isNullOrEmpty()
            && !account.isNullOrEmpty() && account.length > 11 && !sum.isNullOrEmpty()){
            isButtonActive.set(true)
        }else{
            isButtonActive.set(false)
        }

        if(!name.isNullOrEmpty()){
            isNameActive.set(true)
        }
        if(!service.isNullOrEmpty()){
            isChooseActive.set(true)
        }
        if(!account.isNullOrEmpty()){
            isPersonalActive.set(true)
        }
    }

}