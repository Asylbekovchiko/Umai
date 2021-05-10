package ru.mitapp.umai.ui.home.payment.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import ru.mitapp.umai.base.BaseViewModel

class PaymentViewModel: BaseViewModel() {

    var paymentStep = 0
    var account = MutableLiveData<String>("")
    var summ = MutableLiveData<String>("")
    val buttontext = ObservableField("Далее")

}