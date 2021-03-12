package ru.mitapp.umai.ui.home.main.templates.viewmodel

import androidx.databinding.ObservableField
import ru.mitapp.umai.base.BaseViewModel

class PayTempViewModel: BaseViewModel() {
    var isButtonActive = ObservableField(false)
    var isSumActive = ObservableField(false)

    fun checkInputs(sum: String?) {

        if (!sum.isNullOrEmpty()) {
            isButtonActive.set(true)
            isSumActive.set(true)
        } else {
            isSumActive.set(false)
            isButtonActive.set(false)
        }

    }

}