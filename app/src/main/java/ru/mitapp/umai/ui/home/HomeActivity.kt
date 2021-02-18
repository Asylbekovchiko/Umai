package ru.mitapp.umai.ui.home


import androidx.viewpager.widget.ViewPager
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {


    override fun setupView() {

        binding.homePager.adapter =
            HomePagerAdapter(supportFragmentManager)
        binding.homePager.offscreenPageLimit = 5
        binding.homePager.isEnabled = false
        binding.homePager.disableScroll(true)

        binding.homePager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener(){

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                when(position){
                    0 -> binding.homeBottomNavigation.selectedItemId = R.id.main_nav
                    1 -> binding.homeBottomNavigation.selectedItemId = R.id.services_nav
                    2 -> binding.homeBottomNavigation.selectedItemId = R.id.top_up_nav
                    3 -> binding.homeBottomNavigation.selectedItemId = R.id.history_nav
                    4 -> binding.homeBottomNavigation.selectedItemId = R.id.more_nav
                }
            }
        })

        binding.homeBottomNavigation.setOnNavigationItemSelectedListener {
            item ->
            when(item.itemId){
                R.id.main_nav -> binding.homePager.setCurrentItem(0, false)
                R.id.services_nav -> binding.homePager.setCurrentItem(1, false)
                R.id.top_up_nav -> binding.homePager.setCurrentItem(2, false)
                R.id.history_nav -> binding.homePager.setCurrentItem(3, false)
                R.id.more_nav-> binding.homePager.setCurrentItem(4, false)
            }
            true
        }

    }


}