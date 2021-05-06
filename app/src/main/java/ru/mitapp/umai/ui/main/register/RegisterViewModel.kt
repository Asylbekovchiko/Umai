package ru.mitapp.umai.ui.main.register

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.mitapp.umai.AppUmai
import ru.mitapp.umai.base.BaseModel
import ru.mitapp.umai.base.BaseViewModel
import ru.mitapp.umai.models.auth.CreateUser
import ru.mitapp.umai.models.auth.UserToken
import java.lang.Exception

class RegisterViewModel : BaseViewModel() {

    var isButtonActive = ObservableField(false)
    var isLoad = ObservableField(false)

    val createUser: MutableLiveData<BaseModel<UserToken>> by lazy {
        MutableLiveData<BaseModel<UserToken>>()
    }

    fun createUser(user: CreateUser) {
        scope.launch {
            try {
                isLoad.set(true)
                val userList = AppUmai.repository.createUser(user)
                setUserData(userList)
                isLoad.set(false)
            } catch (e: Exception) {
                e.stackTrace
                isLoad.set(false)
            }
        }

    }

    private suspend fun setUserData(userToken: BaseModel<UserToken>)
            : LiveData<BaseModel<UserToken>> {
        withContext(Dispatchers.Main) {
            createUser.value = userToken
        }

        return createUser
    }

    fun checkInputs(name: String?, phone: String?, password: String?, confirm: Boolean?) {
        if (name != null && phone != null  && password != null && confirm != null) {
            val replace = phone.replace("+996", "")
                .replace("(", "")
                .replace(")", "")
                .replace("_", "")
                .replace("-", "")

            if (name.isNotEmpty() && replace.isNotEmpty() && replace.length >= 9
                && password.isNotEmpty() && password.length >= 6 && confirm) {
                isButtonActive.set(true)
            } else {
                isButtonActive.set(false)
            }
        }

    }


}