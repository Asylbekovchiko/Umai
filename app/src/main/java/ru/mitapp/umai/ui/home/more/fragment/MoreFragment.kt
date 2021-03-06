package ru.mitapp.umai.ui.home.more.fragment
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import ru.mitapp.umai.AppUmai.Companion.sharedPreferences
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.FragmentMoreBinding
import ru.mitapp.umai.ui.StartActivity
import ru.mitapp.umai.ui.home.more.linked_cards.LinkedCardsActivity
import ru.mitapp.umai.ui.home.more.partners.activity.PartnersActivity
import ru.mitapp.umai.ui.home.more.personal_data.PersonalDataActivity
import ru.mitapp.umai.ui.home.more.qr_code.QRCodeActivity
import ru.mitapp.umai.ui.home.more.settings.SettingsActivity
import ru.mitapp.umai.ui.home.more.viewmodel.MoreViewModel

class MoreFragment : BaseFragment<FragmentMoreBinding>(R.layout.fragment_more) {

    var viewModel : MoreViewModel? = null

    override fun setupView() {
        if (viewModel == null){
            viewModel = ViewModelProvider(this)[MoreViewModel::class.java]

            binding!!.viewModel = viewModel

            binding!!.refreshLayout.setOnRefreshListener {
                binding!!.refreshLayout.isRefreshing = false
            }

            binding!!.darkThemeSwitch.setOnCheckedChangeListener{_ , isChecked ->
                sharedPreferences.isDarkThem = isChecked

            }

            binding!!.darkThemeSwitch.setOnClickListener{
                val intent = Intent(requireContext(), StartActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                requireActivity().finish()
            }

            binding!!.partners.setOnClickListener {
                val intent = Intent(requireContext(), PartnersActivity::class.java)
                startActivity(intent)
            }
            binding!!.settings.setOnClickListener {
                val intent = Intent(requireContext(), SettingsActivity::class.java)
                startActivity(intent)
            }

            binding!!.qrCode.setOnClickListener {
                val intent = Intent(requireContext(), QRCodeActivity::class.java)
                startActivity(intent)
            }

            binding!!.linkedCards.setOnClickListener {
                val intent = Intent(requireContext(), LinkedCardsActivity::class.java)
                startActivity(intent)
            }
            binding!!.personalData.setOnClickListener {
                val intent = Intent(requireContext(), PersonalDataActivity::class.java)
                startActivity(intent)
            }



        }

    }
}
