package ru.mitapp.umai.ui.registration.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.mitapp.umai.AppUmai
import ru.mitapp.umai.base.BaseModel
import ru.mitapp.umai.base.BaseViewModel
import ru.mitapp.umai.models.auth.SmsCode
import java.lang.Exception

class SmsCodeViewModel : BaseViewModel() {

    var isButtonActive = ObservableField(false)



    val smsCode: MutableLiveData<BaseModel<SmsCode>> by lazy {
        MutableLiveData<BaseModel<SmsCode>>()
    }

    fun checkInputs(smsCode: String?) {

        if (!smsCode.isNullOrEmpty() && smsCode.length >= 5) {
            isButtonActive.set(true)

        } else {
            isButtonActive.set(false)

        }

    }



    fun activateUser(reference: String, smsCode: SmsCode, token: String) {
        scope.launch {
            try {
                isLoad.set(true)
                val smsCodeList = AppUmai.repository.activationUser(reference, smsCode, token)
                setDataUser(smsCodeList)
                isLoad.set(false)
            } catch (e: Exception) {
                e.stackTrace
                isLoad.set(false)
            }
        }

    }

    private suspend fun setDataUser(userToken: BaseModel<SmsCode>)
            : LiveData<BaseModel<SmsCode>> {
        withContext(Dispatchers.Main) {
            smsCode.value = userToken
        }

        return smsCode
    }

}