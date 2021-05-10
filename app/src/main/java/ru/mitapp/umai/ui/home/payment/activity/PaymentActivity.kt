package ru.mitapp.umai.ui.home.payment.activity


import androidx.navigation.NavController
import androidx.navigation.Navigation
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityPaymentBinding


class PaymentActivity : BaseActivity<ActivityPaymentBinding>(R.layout.activity_payment) {
    lateinit var navController: NavController
    override fun setupView() {
        navController = Navigation.findNavController(this, R.id.payment_graph)

    }


}