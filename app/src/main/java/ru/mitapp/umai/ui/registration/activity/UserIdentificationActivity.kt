package ru.mitapp.umai.ui.registration.activity

import android.app.Activity
import android.content.Intent
import androidx.viewpager.widget.ViewPager
import ru.mitapp.umai.AppUmai
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityUserIdentificationBinding
import ru.mitapp.umai.ui.registration.adapter.IdentificationPagerAdapter
import ru.mitapp.umai.ui.registration.fragment.*
import ru.mitapp.umai.ui.registration.listener.IdentificationListener
import ru.mitapp.umai.utils.PASSPORT_PHOTO_REQUEST_CODE
import ru.mitapp.umai.utils.SELFIE_REQUEST_CODE


class UserIdentificationActivity :
    BaseActivity<ActivityUserIdentificationBinding>(R.layout.activity_user_identification),
    IdentificationListener {

    var pagerPosition = 0
    lateinit var adapter: IdentificationPagerAdapter

    var userNameFragment: UserNameFragment? = null
    var userCitizenshipFragment: UserCitizenshipFragment? = null
    var passportInfoForResidentFragment: PassportInfoForResidentFragment? = null
    var passportInfoForNotResidentFragment: PassportInfoForNotResidentFragment? = null
    var passportPhotoFragment: PassportPhotoFragment? = null
    var selfieWithPassportFragment: SelfieWithPassportFragment? = null
    var userAddressResidentFragment: UserAddressResidentFragment? = null
    var userAddressNotResidentFragment: UserAddressNotResidentFragment? = null
    var userEmailFragment: UserEmailFragment? = null

    override fun setupView() {
        userNameFragment = UserNameFragment(this)
        userCitizenshipFragment = UserCitizenshipFragment(this)
        passportInfoForResidentFragment = PassportInfoForResidentFragment(this)
        passportInfoForNotResidentFragment = PassportInfoForNotResidentFragment(this)
        passportPhotoFragment = PassportPhotoFragment(this)
        selfieWithPassportFragment = SelfieWithPassportFragment(this)
        userAddressResidentFragment = UserAddressResidentFragment(this)
        userAddressNotResidentFragment = UserAddressNotResidentFragment(this)
        userEmailFragment = UserEmailFragment(this)
//        val callback = object : OnBackPressedCallback(true) {
//            override fun handleOnBackPressed() {
//                if (pagerPosition == 0) {
//                    isEnabled = false
//                    onBackPressed()
//                } else{
//                    binding.registrationPager.setCurrentItem(pagerPosition -1, false)
//                }
//            }
//
//        }
//        onBackPressedDispatcher.addCallback(this, callback)

        adapter = IdentificationPagerAdapter(
            supportFragmentManager,
            userNameFragment!!,
            userCitizenshipFragment!!,
            passportInfoForResidentFragment!!,
            passportInfoForNotResidentFragment!!,
            passportPhotoFragment!!,
            selfieWithPassportFragment!!,
            userAddressResidentFragment!!,
            userAddressNotResidentFragment!!,
            userEmailFragment!!
        )
        binding!!.registrationPager.adapter = adapter
        binding!!.registrationPager.offscreenPageLimit = 9
        binding!!.registrationPager.isEnabled = false
        binding!!.registrationPager.disableScroll(true)

        binding!!.registrationPager.addOnPageChangeListener(object :
            ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                pagerPosition = position
            }
        })
    }


    override fun onBackPressed() {
        when (pagerPosition) {
            0 -> super.onBackPressed()
            1 -> {
                binding!!.registrationPager.setCurrentItem(0, true)
            }
            2 -> {
                binding!!.registrationPager.setCurrentItem(1, true)
            }
            3 -> {
                binding!!.registrationPager.setCurrentItem(1, false)
            }
            4 -> {
                if (AppUmai.sharedPreferences.isCitizen){
                    binding!!.registrationPager.setCurrentItem(2, false)
                } else{
                    binding!!.registrationPager.setCurrentItem(3, true)
                }

            }
            5 -> {
                binding!!.registrationPager.setCurrentItem(4, true)
            }
            6 -> {
                binding!!.registrationPager.setCurrentItem(5, true)
            }
            7 -> {
                binding!!.registrationPager.setCurrentItem(5, false)
            }
            8 -> {
                if (AppUmai.sharedPreferences.isCitizen){
                    binding!!.registrationPager.setCurrentItem(6, false)
                } else{
                    binding!!.registrationPager.setCurrentItem(7, true)
                }
            }


        }

        binding!!.progressCount.text = "${binding!!.progressBar.progress - 1} из 7 шагов"
        binding!!.progressBar.progress = binding!!.progressBar.progress - 1
    }


    override fun onNextButtonClick() {
        if (pagerPosition != adapter.count - 1) {
            when (pagerPosition) {
                0 -> {
                    binding!!.registrationPager.setCurrentItem(1, true)
                }
                1 -> {
                    if (AppUmai.sharedPreferences.isCitizen){
                        binding!!.registrationPager.setCurrentItem(2, true)
                    } else{
                        binding!!.registrationPager.setCurrentItem(3, false)
                    }

                }
                2 -> {
                    binding!!.registrationPager.setCurrentItem(4, false)
                }
                3 -> {
                    binding!!.registrationPager.setCurrentItem(4, true)
                }
                4 -> {
                    binding!!.registrationPager.setCurrentItem(5, true)
                }
                5 -> {
                    if (AppUmai.sharedPreferences.isCitizen){
                        binding!!.registrationPager.setCurrentItem(6, true)
                    } else{
                        binding!!.registrationPager.setCurrentItem(7, false)
                    }
                }
                6 -> {
                    binding!!.registrationPager.setCurrentItem(8, false)
                }
                7 -> {
                    binding!!.registrationPager.setCurrentItem(8, true)
                }
                8 -> {
                }


            }

            binding!!.progressCount.text = "${binding!!.progressBar.progress + 1} из 7 шагов"
            binding!!.progressBar.progress = binding!!.progressBar.progress + 1
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                PASSPORT_PHOTO_REQUEST_CODE -> passportPhotoFragment?.onActivityResult(
                    requestCode,
                    resultCode,
                    data
                )
                SELFIE_REQUEST_CODE -> selfieWithPassportFragment?.onActivityResult(
                    requestCode,
                    resultCode,
                    data
                )
            }
        }


    }
//    override fun onSupportNavigateUp()
//            = findNavController(R.id.registration_nav_fragment).navigateUp()
}
