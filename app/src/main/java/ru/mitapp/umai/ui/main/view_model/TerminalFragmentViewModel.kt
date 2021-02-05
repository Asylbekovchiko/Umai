package ru.mitapp.umai.ui.main.view_model

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.mitapp.umai.AppUmai
import ru.mitapp.umai.base.BaseModel
import ru.mitapp.umai.base.BaseViewModel
import ru.mitapp.umai.models.Terminal
import java.lang.Exception

class TerminalFragmentViewModel : BaseViewModel() {

    var isLoad = ObservableField(false)


    val terminalsData : MutableLiveData<BaseModel<ArrayList<Terminal>>> by lazy {
        MutableLiveData<BaseModel<ArrayList<Terminal>>>()
    }



    fun getTerminals(){
        scope.launch {
            try {
                isLoad.set(true)
                val terminals = AppUmai.repository.getTerminals()
                setTerminalsData(terminals)
                isLoad.set(false)
            } catch (e : Exception){
                e.stackTrace
                isLoad.set(false)
            }
        }

    }



    private suspend fun setTerminalsData(terminals: BaseModel<ArrayList<Terminal>>) : LiveData<BaseModel<ArrayList<Terminal>>>{
        withContext(Dispatchers.Main){
            terminalsData.value = terminals
        }


        return terminalsData
    }

}