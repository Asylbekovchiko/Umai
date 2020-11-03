package ru.mitapp.umai.ui.registration.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.mitapp.umai.ui.registration.fragment.*

class IdentificationPagerAdapter(
    fm: FragmentManager,
    var userNameFragment: UserNameFragment,
    var userCitizenshipFragment: UserCitizenshipFragment,
    var passportInfoForResidentFragment: PassportInfoForResidentFragment,
    var passportInfoForNotResidentFragment: PassportInfoForNotResidentFragment,
    var passportPhotoFragment : PassportPhotoFragment,
    var selfieWithPassportFragment: SelfieWithPassportFragment,
    var userAddressResidentFragment: UserAddressResidentFragment,
    var userAddressNotResidentFragment: UserAddressNotResidentFragment,
    var userEmailFragment: UserEmailFragment

) : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> userNameFragment
            1 -> userCitizenshipFragment
            2 -> passportInfoForResidentFragment
            3 -> passportInfoForNotResidentFragment
            4 -> passportPhotoFragment
            5 -> selfieWithPassportFragment
            6 -> userAddressResidentFragment
            7 -> userAddressNotResidentFragment
            8 -> userEmailFragment
            else -> userNameFragment
        }
    }

    override fun getCount(): Int {
        return 9
    }


}