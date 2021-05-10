package ru.mitapp.umai.ui.home.payment.fragment


import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.navGraphViewModels
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.FragmentPaymentBinding
import ru.mitapp.umai.ui.home.payment.activity.PaymentActivity
import ru.mitapp.umai.ui.home.payment.viewmodel.PaymentViewModel

class PaymentFragment : BaseFragment<FragmentPaymentBinding>(R.layout.fragment_payment) {
    lateinit var navController: NavController
    lateinit var viewModel: PaymentViewModel
    override fun setupView() {

        viewModel = (activity as PaymentActivity).viewModel
        binding.lifecycleOwner = this
        navController = Navigation.findNavController(requireActivity(), R.id.payment_graph_data)
        binding.viewModel = viewModel
        binding.nextButton.setOnClickListener {
            viewModel.paymentStep++
            when(viewModel.paymentStep){
                1 -> {navController.navigate(R.id.action_paymentDataFragment_to_paymentConfirmFragment)
                    viewModel.buttontext.set("Оплатить")
                }
                else -> {
                    (activity as PaymentActivity).navController.navigate(R.id.action_paymentFragment_to_paymentSuccessFragment2)
                }
            }
        }

    }


}