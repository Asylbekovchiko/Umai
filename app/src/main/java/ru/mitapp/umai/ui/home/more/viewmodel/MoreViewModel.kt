package ru.mitapp.umai.ui.home.more.viewmodel

import androidx.databinding.ObservableField
import ru.mitapp.umai.AppUmai.Companion.sharedPreferences
import ru.mitapp.umai.base.BaseViewModel

class MoreViewModel : BaseViewModel() {

    var isDarkTheme = ObservableField(sharedPreferences.isDarkThem)

}