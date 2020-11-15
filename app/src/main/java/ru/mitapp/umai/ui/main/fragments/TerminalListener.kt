package ru.mitapp.umai.ui.main.fragments

import ru.mitapp.umai.models.Terminal
import ru.mitapp.umai.models.TerminalFilter

interface TerminalListener {

    fun onApplyFilter(filter: TerminalFilter)

    fun showInMap(terminal: Terminal)

}