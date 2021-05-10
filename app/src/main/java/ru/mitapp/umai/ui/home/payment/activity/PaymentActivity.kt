package ru.mitapp.umai.ui.home.payment.activity


import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityPaymentBinding
import ru.mitapp.umai.ui.home.payment.viewmodel.PaymentViewModel


class PaymentActivity : BaseActivity<ActivityPaymentBinding>(R.layout.activity_payment) {
    lateinit var navController: NavController

    lateinit var viewModel: PaymentViewModel

    override fun setupView() {
        viewModel = ViewModelProvider(this)[PaymentViewModel::class.java]
        navController = Navigation.findNavController(this, R.id.graph_payment)

        binding.toolbar.backBtn.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        viewModel.paymentStep--
        when(viewModel.paymentStep){
            0 -> viewModel.buttontext.set("Далее")

        }
    }







}