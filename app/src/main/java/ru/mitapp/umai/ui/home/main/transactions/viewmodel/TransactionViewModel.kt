package ru.mitapp.umai.ui.home.main.transactions.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class TransactionViewModel : ViewModel() {

    var isButtonActive = ObservableField(false)
    var isPersonalActive = ObservableField(false)
    var isSumActive = ObservableField(false)

    fun checkInputs(account: String?, sum: String?) {
        val repAccount = account?.replace("X", "")?.replace("-", "")
        if (!repAccount.isNullOrEmpty() && repAccount.length > 15 && !sum.isNullOrEmpty() && sum.toInt() >= 50
        ) {
            isButtonActive.set(true)
        } else {
            isButtonActive.set(false)
        }

        if (!repAccount.isNullOrEmpty() && repAccount.length > 15) {
            isPersonalActive.set(true)
        } else {
            isPersonalActive.set(false)
        }

        if (!sum.isNullOrEmpty() && sum.toInt() >= 50) {
            isSumActive.set(true)
        } else {
            isSumActive.set(false)
        }
    }

}