package ru.mitapp.umai.ui.home.payment.fragment


import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.FragmentPaymentDataBinding
import ru.mitapp.umai.ui.home.payment.activity.PaymentActivity
import ru.mitapp.umai.ui.home.payment.viewmodel.PaymentViewModel

class PaymentDataFragment : BaseFragment<FragmentPaymentDataBinding>(R.layout.fragment_payment_data) {

    lateinit var viewModel: PaymentViewModel
    override fun setupView() {
        viewModel = (activity as PaymentActivity).viewModel

    }


}