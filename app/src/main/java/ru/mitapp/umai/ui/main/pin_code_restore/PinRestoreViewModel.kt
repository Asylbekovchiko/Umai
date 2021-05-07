package ru.mitapp.umai.ui.main.pin_code_restore

import androidx.databinding.ObservableField
import ru.mitapp.umai.base.BaseViewModel

class PinRestoreViewModel: BaseViewModel() {

    var isButtonActive = ObservableField(false)

    var isLoad = ObservableField(false)

    fun checkInputs(smsCode: String?) {

        if (!smsCode.isNullOrEmpty() && smsCode.length >= 6) {
            isButtonActive.set(true)

        } else {
            isButtonActive.set(false)

        }

    }

}