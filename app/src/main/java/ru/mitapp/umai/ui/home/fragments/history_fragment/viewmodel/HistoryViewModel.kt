package ru.mitapp.umai.ui.home.fragments.history_fragment.viewmodel

import android.view.View
import androidx.databinding.BindingConversion
import androidx.databinding.ObservableField
import ru.mitapp.umai.base.BaseViewModel
import ru.mitapp.umai.models.history_model.HistoryModel
import java.util.ArrayList

class HistoryViewModel: BaseViewModel() {

    var isListEmpty = ObservableField(false)

    fun checkList(list: ArrayList<HistoryModel>){
        isListEmpty.set(list.isNullOrEmpty())
    }


}