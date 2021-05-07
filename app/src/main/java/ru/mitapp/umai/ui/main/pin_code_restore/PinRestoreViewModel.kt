package ru.mitapp.umai.ui.main.pin_code_restore

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
import ru.mitapp.umai.models.auth.Phone
import ru.mitapp.umai.models.auth.PinCode
import java.lang.Exception

class PinRestoreViewModel: BaseViewModel() {

    var isButtonActive = ObservableField(false)

    var isLoad = ObservableField(false)


    val checkPinCode: MutableLiveData<BaseModel<ResponseBody>> by lazy {
        MutableLiveData<BaseModel<ResponseBody>>()
    }


    fun checkPinCode(pinCode: PinCode) {
        scope.launch {
            try {
                isLoad.set(true)
                val password = AppUmai.repository.checkCode(pinCode)
                setResorePassword(password)
                isLoad.set(false)
            } catch (e: Exception) {
                e.stackTrace
                isLoad.set(false)
            }
        }

    }

    private suspend fun setResorePassword(password: BaseModel<ResponseBody>)
            : LiveData<BaseModel<ResponseBody>> {
        withContext(Dispatchers.Main) {
            checkPinCode.value = password
        }

        return checkPinCode
    }


    fun checkInputs(smsCode: String?) {

        if (!smsCode.isNullOrEmpty() && smsCode.length >= 6) {
            isButtonActive.set(true)

        } else {
            isButtonActive.set(false)

        }

    }

}