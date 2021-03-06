package ru.mitapp.umai.base

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import ru.mitapp.umai.AppUmai
import ru.mitapp.umai.utils.ConnectionLiveData
import kotlin.coroutines.CoroutineContext

open class BaseViewModel : ViewModel() {

    private val jobs = Job()
    private val coroutineContext : CoroutineContext
        get() = jobs + Dispatchers.IO
    val scope = CoroutineScope(coroutineContext)
    var isLoad = ObservableField(false)

    var connection =  ConnectionLiveData(AppUmai.context)


}