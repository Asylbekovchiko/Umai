package ru.mitapp.umai.ui.home.service.viewmodel

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.mitapp.umai.AppUmai.Companion.repository
import ru.mitapp.umai.base.BaseModel
import ru.mitapp.umai.base.BaseViewModel
import ru.mitapp.umai.models.service.Service
import java.lang.Exception
import java.util.ArrayList

class ServiceViewModel : BaseViewModel() {

    val data : MutableLiveData<BaseModel<ArrayList<Service>>> by lazy {
        MutableLiveData<BaseModel<ArrayList<Service>>>()
    }

    fun getServices(){
        scope.launch {
            try {
                isLoad.set(true)
                val response = repository.getServices()
                setData(response)
                isLoad.set(false)
            }catch (e: Exception){
                e.stackTrace
                isLoad.set(false)
            }
        }
    }

    suspend fun setData(data:BaseModel<ArrayList<Service>>){
        withContext(Dispatchers.Main) {
            this@ServiceViewModel.data.postValue(data)
        }

    }

}