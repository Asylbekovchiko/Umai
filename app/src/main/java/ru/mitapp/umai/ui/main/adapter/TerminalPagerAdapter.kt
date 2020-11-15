package ru.mitapp.umai.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.mitapp.umai.ui.main.fragments.TerminalListFragment
import ru.mitapp.umai.ui.main.fragments.TerminalMapFragment

class TerminalPagerAdapter(
    fm: FragmentManager,
    var titles: ArrayList<String>,
    var terminalMapFragment: TerminalMapFragment,
    var terminalListFragment: TerminalListFragment
    ) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> terminalMapFragment
            1 -> terminalListFragment
            else -> terminalMapFragment
        }
    }

    override fun getCount(): Int {
        return titles.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]

    }
}