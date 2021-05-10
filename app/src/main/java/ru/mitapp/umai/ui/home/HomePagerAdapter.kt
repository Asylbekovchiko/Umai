package ru.mitapp.umai.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.mitapp.umai.ui.home.card.fragment.CardFragment
import ru.mitapp.umai.ui.home.history.fragment.HistoryFragment
import ru.mitapp.umai.ui.home.service.fragment.ServiceFragment
import ru.mitapp.umai.ui.home.main.HomeFragment
import ru.mitapp.umai.ui.home.more.fragment.MoreFragment

class HomePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {

        return when(position){
            0 -> HomeFragment()
            1 -> ServiceFragment()
            2 -> CardFragment()
            3 -> HistoryFragment()
            else -> MoreFragment()
        }
    }

    override fun getCount(): Int {
        return 5
    }
}