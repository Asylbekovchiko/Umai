package ru.mitapp.umai.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.mitapp.umai.ui.home.fragments.*
import ru.mitapp.umai.ui.home.fragments.service_fragment.ServiceFragment

class HomePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {

        return when(position){
            0 -> HomeFragment()
            1 -> ServiceFragment()
            2 -> TopUpFragment()
            3 -> HistoryFragment()
            else -> MoreFragment()
        }
    }

    override fun getCount(): Int {
        return 5
    }
}