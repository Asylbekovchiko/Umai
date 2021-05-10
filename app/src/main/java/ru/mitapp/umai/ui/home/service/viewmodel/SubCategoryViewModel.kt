package ru.mitapp.umai.ui.home.service.viewmodel

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.mitapp.umai.AppUmai
import ru.mitapp.umai.base.BaseModel
import ru.mitapp.umai.base.BaseViewModel
import ru.mitapp.umai.models.service.SubCategoryService
import java.lang.Exception
import java.util.ArrayList

class SubCategoryViewModel:BaseViewModel() {

    val data: MutableLiveData<BaseModel<ArrayList<SubCategoryService>>> by lazy {
        MutableLiveData<BaseModel<ArrayList<SubCategoryService>>>()
    }

    fun getServices(id: String){
        scope.launch {
            try {
                isLoad.set(true)
                val response = AppUmai.repository.getSecondLevelCategory(id)
                withContext(Dispatchers.Main){
                    data.postValue(response)
                }
                isLoad.set(false)
            }catch (e: Exception){
                e.stackTrace
                isLoad.set(false)
            }
        }
    }

}