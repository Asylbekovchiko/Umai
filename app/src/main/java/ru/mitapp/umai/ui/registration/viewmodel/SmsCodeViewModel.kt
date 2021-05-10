package ru.mitapp.umai.ui.registration.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import ru.mitapp.umai.AppUmai
import ru.mitapp.umai.base.BaseModel
import ru.mitapp.umai.base.BaseViewModel
import ru.mitapp.umai.models.auth.SmsCode
import java.lang.Exception

class SmsCodeViewModel : BaseViewModel() {

    var isButtonActive = ObservableField(false)

    var isLoad = ObservableField(false)


    val smsCode: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun checkInputs(smsCode: String?) {

        if (!smsCode.isNullOrEmpty() && smsCode.length >= 5) {
            isButtonActive.set(true)

        } else {
            isButtonActive.set(false)

        }

    }



    fun activateUser(reference: String, smsCodeModel: SmsCode, token: String) {
        scope.launch {
            try {
                isLoad.set(true)
                val smsCodeList = AppUmai.repository.activationUser(reference, smsCodeModel, token)
                if (smsCodeList.responseCode == 204){
                    withContext(Dispatchers.Main) {
                        smsCode.value = true
                    }
                    isLoad.set(false)
                }else{
                    withContext(Dispatchers.Main) {
                        smsCode.value = false
                    }
                    isLoad.set(false)
                }
                isLoad.set(false)
            } catch (e: Exception) {
                e.stackTrace
                withContext(Dispatchers.Main) {
                    smsCode.value = false
                }
                isLoad.set(false)
            }
        }

    }


}