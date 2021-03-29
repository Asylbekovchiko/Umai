package ru.mitapp.umai.ui.main.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.widget.TableLayout
import androidx.lifecycle.Observer
import com.google.android.material.tabs.TabLayout
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.TerminalFragmentBinding
import ru.mitapp.umai.models.Terminal
import ru.mitapp.umai.models.TerminalFilter
import ru.mitapp.umai.ui.main.adapter.TerminalPagerAdapter
import ru.mitapp.umai.ui.main.dialog.TerminalFilterDialog
import ru.mitapp.umai.ui.main.view_model.TerminalFragmentViewModel

class TerminalFragment : BaseFragment<TerminalFragmentBinding>(R.layout.terminal_fragment), TerminalListener {


    private lateinit var viewModel: TerminalFragmentViewModel
    var tabTitles : ArrayList<String> = ArrayList()
     var pagerAdapter : TerminalPagerAdapter? = null
    var terminalMapFragment: TerminalMapFragment? = null
    var terminalListFragment: TerminalListFragment? = null
    var filterDialog : TerminalFilterDialog? = null
    var terminals : ArrayList<Terminal> = ArrayList()


    override fun setupView() {
        viewModel = ViewModelProviders.of(this).get(TerminalFragmentViewModel::class.java)

        viewModel.getTerminals()

        viewModel.terminalsData.observe(this, Observer {
            if (it.data != null){
                terminals = it.data!!
            }
            terminalMapFragment = TerminalMapFragment(this, terminals)
            terminalListFragment = TerminalListFragment(this, terminals)
            tabTitles.add(getString(R.string.maps))
            tabTitles.add(getString(R.string.list))
            filterDialog = TerminalFilterDialog(this)
            pagerAdapter = TerminalPagerAdapter(requireActivity().supportFragmentManager, tabTitles, terminalMapFragment!!, terminalListFragment!!)

            setupPager()

            binding!!.terminalFilter.setOnClickListener{
                if (filterDialog != null)
                    filterDialog!!.show(requireActivity().supportFragmentManager, "filterDialog")
            }
        })



    }

    private fun setupPager() {
        binding!!.terminalTab.tabGravity = TabLayout.GRAVITY_FILL
        binding!!.terminalTab.tabMode = TabLayout.MODE_FIXED
        binding!!.terminalPager.offscreenPageLimit = tabTitles.size
        binding!!.terminalPager.adapter = pagerAdapter
        binding!!.terminalTab.setupWithViewPager(binding!!.terminalPager)
    }

    override fun onApplyFilter(filter: TerminalFilter) {

    }

    override fun showInMap(terminal: Terminal) {

    }

}