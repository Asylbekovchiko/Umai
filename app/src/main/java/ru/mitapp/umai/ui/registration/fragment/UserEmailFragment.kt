package ru.mitapp.umai.ui.registration.fragment

import androidx.lifecycle.ViewModelProviders
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.UserEmailFragmentBinding
import ru.mitapp.umai.ui.registration.listener.IdentificationListener
import ru.mitapp.umai.ui.registration.viewmodel.UserEmailViewModel

class UserEmailFragment(var listener: IdentificationListener) : BaseFragment<UserEmailFragmentBinding>(R.layout.user_email_fragment) {

    private lateinit var viewModel: UserEmailViewModel

    override fun setupView() {
        viewModel = ViewModelProviders.of(this).get(UserEmailViewModel::class.java)
    }
}