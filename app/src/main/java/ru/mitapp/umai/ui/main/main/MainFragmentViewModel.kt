package ru.mitapp.umai.ui.main.main

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
import ru.mitapp.umai.models.auth.SingIn
import java.lang.Exception

class MainFragmentViewModel : BaseViewModel() {


    var isButtonActive = ObservableField(false)
    var isLoad = ObservableField(false)

    val createUser: MutableLiveData<BaseModel<UserToken>> by lazy {
        MutableLiveData<BaseModel<UserToken>>()
    }

    val singIn: MutableLiveData<BaseModel<UserToken>> by lazy {
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

    fun singInUser(singIn: SingIn) {
        scope.launch {
            try {
                isLoad.set(true)
                val singInList = AppUmai.repository.signIn(singIn)
                setSingIn(singInList)
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

    private suspend fun setSingIn(userToken: BaseModel<UserToken>)
            : LiveData<BaseModel<UserToken>> {
        withContext(Dispatchers.Main) {
            singIn.value = userToken
        }

        return singIn
    }


    fun checkInputs(phone: String?, password: String?) {
        if (phone != null && password != null) {
            val replace = phone.replace("+996", "")
                .replace("(", "")
                .replace(")", "")
                .replace("_", "")
                .replace("-", "")

            if (replace.isNotEmpty() && replace.length >= 9 && password.isNotEmpty()) {
                isButtonActive.set(true)
            } else {
                isButtonActive.set(false)
            }
        }

    }

}