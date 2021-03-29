package ru.mitapp.umai.ui.home.main.templates.viewmodel

import androidx.databinding.ObservableField
import ru.mitapp.umai.base.BaseViewModel

class CreateTemplatesViewModel : BaseViewModel() {

    var isButtonActive = ObservableField(false)
    var isEditButtonActive = ObservableField(false)
    var isNameActive = ObservableField(false)
    var isChooseActive = ObservableField(false)
    var isPersonalActive = ObservableField(false)
    var isSumActive = ObservableField(false)

    fun checkInputs(name: String?, service: String?, account: String?, sum: String?) {
        val repAccount = account?.replace("X", "")?.replace("-","")
        if (!name.isNullOrEmpty() && !service.isNullOrEmpty()
            && !repAccount.isNullOrEmpty() && repAccount.length > 11 && !sum.isNullOrEmpty()
        ) {
            isButtonActive.set(true)
        } else {
            isButtonActive.set(false)
        }

        if (!name.isNullOrEmpty()) {
            isNameActive.set(true)
        } else {
            isNameActive.set(false)
        }

        if (!service.isNullOrEmpty()) {
            isChooseActive.set(true)
        } else {
            isChooseActive.set(false)
        }

        if (!repAccount.isNullOrEmpty() && repAccount.length > 11) {
            isPersonalActive.set(true)
        } else {
            isPersonalActive.set(false)
        }

        if (!sum.isNullOrEmpty()) {
            isSumActive.set(true)
        } else {
            isSumActive.set(false)
        }

    }
    fun checkEditInputs(name: String?, account: String?, sum: String?) {
        val repAccount = account?.replace("X", "")?.replace("-","")
        if (!name.isNullOrEmpty() && !repAccount.isNullOrEmpty()
            && repAccount.length > 11 && !sum.isNullOrEmpty()) {
            isEditButtonActive.set(true)
        } else {
            isEditButtonActive.set(false)
        }

        if (!name.isNullOrEmpty()) {
            isNameActive.set(true)
        } else {
            isNameActive.set(false)
        }

        if (!repAccount.isNullOrEmpty() && repAccount.length > 11) {
            isPersonalActive.set(true)
        } else {
            isPersonalActive.set(false)
        }

        if (!sum.isNullOrEmpty()) {
            isSumActive.set(true)
        } else {
            isSumActive.set(false)
        }

    }
}