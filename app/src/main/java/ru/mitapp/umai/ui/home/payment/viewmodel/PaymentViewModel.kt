package ru.mitapp.umai.ui.home.payment.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.mitapp.umai.AppUmai
import ru.mitapp.umai.AppUmai.Companion.repository
import ru.mitapp.umai.base.BaseModel
import ru.mitapp.umai.base.BaseViewModel
import ru.mitapp.umai.models.service.ServiceDetail
import java.lang.Exception

class PaymentViewModel: BaseViewModel() {

    var paymentStep = 0
    var account = MutableLiveData<String>("")
    var summ = MutableLiveData<String>("")
    val buttontext = ObservableField("Далее")

    var image = "https://www.aknet.kg/ima/aknet.jpg"

    val data: MutableLiveData<BaseModel<ServiceDetail>> by lazy {
        MutableLiveData<BaseModel<ServiceDetail>>()
    }

    fun getService(type: String){
        scope.launch {
            try {
                isLoad.set(true)
                val response = repository.getServicesDetail(type)
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