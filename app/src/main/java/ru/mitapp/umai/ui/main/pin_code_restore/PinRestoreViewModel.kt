package ru.mitapp.umai.ui.main.pin_code_restore

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.tools.build.jetifier.core.utils.Log
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


    val checkPinCode: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }


    fun checkPinCode(pinCode: PinCode) {
        scope.launch {
            try {
                isLoad.set(true)
                val password = AppUmai.repository.checkCode(pinCode)
                Log.i("responseCode", password.responseCode.toString())
                if (password.responseCode == 204){
                    withContext(Dispatchers.Main) {
                        checkPinCode.value = true
                    }
                    isLoad.set(false)
                }else{
                    withContext(Dispatchers.Main) {
                        checkPinCode.value = false
                    }
                    isLoad.set(false)
                }

            } catch (e: Exception) {
                e.stackTrace
                withContext(Dispatchers.Main) {
                    checkPinCode.value = false
                }
                isLoad.set(false)
            }
        }

    }



    fun checkInputs(smsCode: String?) {

        if (!smsCode.isNullOrEmpty() && smsCode.length >= 6) {
            isButtonActive.set(true)

        } else {
            isButtonActive.set(false)

        }

    }

}