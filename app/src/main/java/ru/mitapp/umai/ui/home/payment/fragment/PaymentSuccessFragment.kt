package ru.mitapp.umai.ui.home.payment.fragment


import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.FragmentPaymentSuccessBinding
import ru.mitapp.umai.ui.home.payment.activity.PaymentActivity
import ru.mitapp.umai.ui.home.payment.viewmodel.PaymentViewModel


class PaymentSuccessFragment : BaseFragment<FragmentPaymentSuccessBinding>(R.layout.fragment_payment_success) {
    lateinit var viewModel: PaymentViewModel
    override fun setupView() {
        viewModel = (activity as PaymentActivity).viewModel

    }

}