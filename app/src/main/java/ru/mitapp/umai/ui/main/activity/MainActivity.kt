package ru.mitapp.umai.ui.main.activity


import androidx.viewpager.widget.ViewPager
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityMainBinding
import ru.mitapp.umai.ui.main.adapter.MainPagerAdapter

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {



    override fun setupView() {
        binding.mainPager.adapter = MainPagerAdapter(supportFragmentManager)
        binding.mainPager.offscreenPageLimit = 3
        binding.mainPager.isEnabled = false
        binding.mainPager.disableScroll(true)

        binding.mainPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position){
                    0 -> binding.mainBottomNavigation.selectedItemId = R.id.login_nav
                    1 -> binding.mainBottomNavigation.selectedItemId = R.id.map_nav
                    2 -> binding.mainBottomNavigation.selectedItemId = R.id.news_nav
                }
            }
        })


        binding.mainBottomNavigation.setOnNavigationItemSelectedListener {
            item ->
            when(item.itemId){
               R.id.login_nav -> binding.mainPager.setCurrentItem(0, false)
               R.id.map_nav -> binding.mainPager.setCurrentItem(1, false)
               R.id.news_nav -> binding.mainPager.setCurrentItem(2, false)
            }

            true
        }
    }

}