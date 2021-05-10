package ru.mitapp.umai.ui.main.terminal.terminal_dialog

import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseDialogFragment
import ru.mitapp.umai.databinding.DialogTerminalMapBinding
import ru.mitapp.umai.models.Terminal

class TerminalMapDialog() :
    BaseDialogFragment<DialogTerminalMapBinding>(R.layout.dialog_terminal_map) {
    var terminal: Terminal? = Terminal()
    private var clickCallback: ClickMarker? = null

    fun setCallback(clickCallback: ClickMarker?) {
        this.clickCallback = clickCallback
    }

    override fun init() {
        arguments?.let {
            if (it.containsKey("terminal")) {
                terminal = it.getParcelable("terminal")
                binding.textAddress.text = terminal?.address
                binding.textWorkingTime.text = terminal?.workingTime
            }
        }
        /*if (arguments?.containsKey("terminal")) {
            binding.textAddress.text = arguments?.getString("key")
            binding.textWorkingTime.text = arguments?.getString("time")
        } else if (arguments?.getString("address") != null) {
            binding.textAddress.text = arguments?.getString("address")
            binding.textWorkingTime.text = arguments?.getString("work_time")
        }*/
        binding.but.setOnClickListener {
            terminal?.let {
             clickCallback?.onClickButtonMarker(it)
            }
            dismiss()
        }
    }

    interface ClickMarker {
        fun onClickButtonMarker(terminal: Terminal)
    }
}