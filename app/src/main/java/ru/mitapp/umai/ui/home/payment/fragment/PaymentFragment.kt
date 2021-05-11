package ru.mitapp.umai.ui.home.payment.fragment


import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.navGraphViewModels
import com.anggastudio.dynamicimagegetter.DynamicImageGetter
import kotlinx.coroutines.launch
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

        viewModel.data.observe(this, Observer {
            binding.model = it.data
            it.data!!.description?.let { it1 -> loadIcon(it1) }

        })


        binding.nextButton.setOnClickListener {
            viewModel.paymentStep++
            when(viewModel.paymentStep){
                1 -> {navController.navigate(R.id.action_paymentDataFragment_to_paymentConfirmFragment)
                    viewModel.buttontext.set(getString(R.string.pay))
                }
                else -> {
                    (activity as PaymentActivity).navController.navigate(R.id.action_paymentFragment_to_paymentSuccessFragment2)
                }
            }
        }
    }

    private fun loadIcon(url: String){
        DynamicImageGetter.with(requireContext())
            .load(url)
            .mode(DynamicImageGetter.INLINE_TEXT)
            .into(binding.labelIcon)
    }


}