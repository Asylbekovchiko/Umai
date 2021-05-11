package ru.mitapp.umai.ui.home.payment.activity


import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityPaymentBinding
import ru.mitapp.umai.ui.home.payment.viewmodel.PaymentViewModel
import ru.mitapp.umai.utils.SERVICE_TYPE


class PaymentActivity : BaseActivity<ActivityPaymentBinding>(R.layout.activity_payment) {
    lateinit var navController: NavController

    lateinit var viewModel: PaymentViewModel

    val type: String?
        get() = intent.getStringExtra(SERVICE_TYPE)

    override fun setupView() {
        viewModel = ViewModelProvider(this)[PaymentViewModel::class.java]
        navController = Navigation.findNavController(this, R.id.graph_payment)

        viewModel.getService(type!!)

        binding.toolbar.backBtn.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        viewModel.paymentStep--
        when(viewModel.paymentStep){
            0 -> viewModel.buttontext.set(getString(R.string.next_button))

        }
    }







}