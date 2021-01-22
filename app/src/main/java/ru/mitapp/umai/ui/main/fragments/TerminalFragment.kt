package ru.mitapp.umai.ui.main.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.widget.TableLayout
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

        fillTerminals()
        terminalMapFragment = TerminalMapFragment(this, terminals)
        terminalListFragment = TerminalListFragment(this, terminals)
        tabTitles.add(getString(R.string.maps))
        tabTitles.add(getString(R.string.list))
        filterDialog = TerminalFilterDialog(this)
        pagerAdapter = TerminalPagerAdapter(requireActivity().supportFragmentManager, tabTitles, terminalMapFragment!!, terminalListFragment!!)

        setupPager()

        binding.terminalFilter.setOnClickListener{
            if (filterDialog != null)
            filterDialog!!.show(requireActivity().supportFragmentManager, "filterDialog")
        }

    }


    private fun fillTerminals(){
        terminals.add(Terminal("Терминал", "100 м", "ул. Советская 45а", "T", 42.868751,74.613963 ))
        terminals.add(Terminal("Банкомат", "530 м", "пр. Мира 435", "A", 42.858222, 74.567995))
        terminals.add(Terminal("Банкомат", "290 м", "ул. Ауэзова 13б", "A", 42.865709, 74.582041))
        terminals.add(Terminal("Офис", "1,5 км", "ул. Куренкеева 356", "O", 42.877056, 74.579328))
        terminals.add(Terminal("Терминал", "500 м", "ул. Калинина 221", "T", 42.875535, 74.581881))
        terminals.add(Terminal("Офис", "192 м", "ул. Ибрагимова 13", "O", 42.878226, 74.572624))
        terminals.add(Terminal("Банкомат", "987 м", "ул. Курманжан Датка 4/б", "A", 42.878408, 74.568482))
    }

    private fun setupPager() {
        binding.terminalTab.tabGravity = TabLayout.GRAVITY_FILL
        binding.terminalTab.tabMode = TabLayout.MODE_FIXED
        binding.terminalPager.offscreenPageLimit = tabTitles.size
        binding.terminalPager.adapter = pagerAdapter
        binding.terminalTab.setupWithViewPager(binding.terminalPager)
    }

    override fun onApplyFilter(filter: TerminalFilter) {

    }

    override fun showInMap(terminal: Terminal) {

    }

}