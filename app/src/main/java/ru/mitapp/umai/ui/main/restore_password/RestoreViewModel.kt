package ru.mitapp.umai.ui.main.restore_password

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.mitapp.umai.AppUmai
import ru.mitapp.umai.base.BaseModel
import ru.mitapp.umai.base.BaseViewModel
import ru.mitapp.umai.models.auth.Phone
import java.lang.Exception

class RestoreViewModel: BaseViewModel() {

    var isButtonActive = ObservableField(false)

    var isLoad = ObservableField(false)


    val restorePassword: MutableLiveData<BaseModel<String>> by lazy {
        MutableLiveData<BaseModel<String>>()
    }


    fun restorePassword(phone: Phone) {
        scope.launch {
            try {
                isLoad.set(true)
                val password = AppUmai.repository.restorePassword(phone)
                setResorePassword(password)
                isLoad.set(false)
            } catch (e: Exception) {
                e.stackTrace
                isLoad.set(false)
            }
        }

    }

    private suspend fun setResorePassword(password: BaseModel<String>)
            : LiveData<BaseModel<String>> {
        withContext(Dispatchers.Main) {
            restorePassword.value = password
        }

        return restorePassword
    }


    fun checkInputs(phone: String?) {
        if (phone != null) {
            val replace = phone.replace("+996", "")
                .replace("(", "")
                .replace(")", "")
                .replace("_", "")
                .replace("-", "")

            if (replace.isNotEmpty() && replace.length >= 9
            ) {
                isButtonActive.set(true)
            } else {
                isButtonActive.set(false)
            }
        }

    }

}