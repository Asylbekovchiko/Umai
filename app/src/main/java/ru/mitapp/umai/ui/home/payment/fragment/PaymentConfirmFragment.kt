package ru.mitapp.umai.ui.home.payment.fragment


import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.FragmentPaymentConfirmBinding
import ru.mitapp.umai.ui.home.payment.activity.PaymentActivity
import ru.mitapp.umai.ui.home.payment.viewmodel.PaymentViewModel


class PaymentConfirmFragment : BaseFragment<FragmentPaymentConfirmBinding>(R.layout.fragment_payment_confirm) {

    lateinit var viewModel: PaymentViewModel
    override fun setupView() {
        viewModel = (activity as PaymentActivity).viewModel
        binding.viewModel = viewModel

    }

}