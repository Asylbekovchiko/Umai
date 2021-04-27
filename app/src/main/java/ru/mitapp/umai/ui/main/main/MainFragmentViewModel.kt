package ru.mitapp.umai.ui.main.main

import androidx.databinding.ObservableField
import ru.mitapp.umai.base.BaseViewModel

class MainFragmentViewModel : BaseViewModel() {


    var isButtonActive = ObservableField(false)

    fun checkInputs(phone: String?, isChecked: Boolean) {
        if (phone != null) {
            val replace = phone.replace("+996", "")
                .replace("(", "")
                .replace(")", "")
                .replace("_", "")
                .replace("-", "")

            if (replace.isNotEmpty() && replace.length >= 9 && isChecked) {
                isButtonActive.set(true)
            } else {
                isButtonActive.set(false)
            }
        }

    }

}