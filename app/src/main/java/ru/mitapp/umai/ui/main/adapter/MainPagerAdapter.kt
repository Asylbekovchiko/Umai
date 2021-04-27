package ru.mitapp.umai.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.mitapp.umai.ui.main.main.MainFragment
import ru.mitapp.umai.ui.main.fragments.TerminalFragment
import ru.mitapp.umai.ui.main.news.NewsFragment

class MainPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {

        return when(position){
            0 -> MainFragment()
            1 -> TerminalFragment()
            else -> NewsFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }
}