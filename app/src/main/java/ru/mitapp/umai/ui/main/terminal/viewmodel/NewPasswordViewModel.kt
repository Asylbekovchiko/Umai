package ru.mitapp.umai.ui.main.view_model

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
import ru.mitapp.umai.models.auth.NewPassword
import java.lang.Exception

class NewPasswordViewModel: BaseViewModel() {

    var isButtonActive = ObservableField(false)



    val newsPassword: MutableLiveData<BaseModel<ResponseBody>> by lazy {
        MutableLiveData<BaseModel<ResponseBody>>()
    }


    fun newsPassword(newPassword: NewPassword) {
        scope.launch {
            try {
                isLoad.set(true)
                val password = AppUmai.repository.newPassword(newPassword)
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
            newsPassword.value = password
        }

        return newsPassword
    }

    fun checkInputs(password: String?, passwordConfirm: String?) {
        if (password != null && passwordConfirm != null) {

            if (password.isNotEmpty() && password.length >= 6
                && passwordConfirm.isNotEmpty() && passwordConfirm.length >= 6
            ) {
                isButtonActive.set(true)
            } else {
                isButtonActive.set(false)
            }
        }

    }

}