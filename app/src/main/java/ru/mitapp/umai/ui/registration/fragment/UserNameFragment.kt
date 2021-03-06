package ru.mitapp.umai.ui.registration.fragment

import android.app.DatePickerDialog
import android.text.Editable
import android.view.View
import android.widget.DatePicker
import androidx.lifecycle.ViewModelProviders
import com.tsongkha.spinnerdatepicker.SpinnerDatePickerDialogBuilder
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.UserNameFragmentBinding
import ru.mitapp.umai.helper.BaseTextChangeListener
import ru.mitapp.umai.ui.registration.listener.IdentificationListener
import ru.mitapp.umai.ui.registration.viewmodel.UserNameViewModel
import ru.mitapp.umai.utils.DateConverter
import java.text.SimpleDateFormat
import java.util.*

class UserNameFragment(var listener: IdentificationListener) :
    BaseFragment<UserNameFragmentBinding>(R.layout.user_name_fragment),
    com.tsongkha.spinnerdatepicker.DatePickerDialog.OnDateSetListener {

    private lateinit var viewModel: UserNameViewModel
    private var calendar: Calendar = Calendar.getInstance()
    private var nowCalendar: Calendar = Calendar.getInstance()

    override fun setupView() {
        viewModel = ViewModelProviders.of(this).get(UserNameViewModel::class.java)

        binding!!.viewModel = viewModel

        binding!!.nextButton.setOnClickListener {
            listener.onNextButtonClick()
        }

        binding!!.dateBirthInput.setOnClickListener {
            showDataPickerDialog(it)
        }

        binding!!.surnameInput.addTextChangedListener(object : BaseTextChangeListener(){
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })

        binding!!.nameInput.addTextChangedListener(object : BaseTextChangeListener(){
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })

        binding!!.middleNameInput.addTextChangedListener(object : BaseTextChangeListener(){
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })

        binding!!.dateBirthInput.addTextChangedListener(object : BaseTextChangeListener(){
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })

    }

    fun checkInputs(){
        viewModel.checkInputs(
            binding!!.surnameInput.text.toString(),
            binding!!.nameInput.text.toString(),
            binding!!.middleNameInput.text.toString(),
            binding!!.dateBirthInput.text.toString()
        )
    }

    private fun showDataPickerDialog(v: View?) {
        SpinnerDatePickerDialogBuilder()
            .context(activity)
            .callback(this)
            .spinnerTheme(R.style.NumberPickerStyle)
            .showTitle(true)
            .showDaySpinner(true)
            .defaultDate(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            .maxDate(nowCalendar.get(Calendar.YEAR), nowCalendar.get(Calendar.MONTH), nowCalendar.get(Calendar.DAY_OF_MONTH))
            .minDate(1900, 0, 1)
            .build()
            .show()
    }

//    private fun showCalendarDialog() {
//        DatePickerDialog(
//            requireContext(),
//            R.style.MyDatePickerTheme,
//            calendarListener,
//            calendar.get(Calendar.YEAR),
//            calendar.get(Calendar.MONTH),
//            calendar.get(Calendar.DAY_OF_MONTH)
//        )
//            .show()
//    }
//
//
//    private var calendarListener =
//        DatePickerDialog.OnDateSetListener { _: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
//            calendar.set(Calendar.YEAR, year)
//            calendar.set(Calendar.MONTH, monthOfYear)
//            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//
//            binding.dateBirthInput.text = DateConverter.converterDateToString("dd-MM-yyyy", calendar.time)
//
//
//        }

    override fun onDateSet(
        view: com.tsongkha.spinnerdatepicker.DatePicker?,
        year: Int,
        monthOfYear: Int,
        dayOfMonth: Int
    ) {
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, monthOfYear)
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

        binding!!.dateBirthInput.text = DateConverter.converterDateToString("dd-MM-yyyy", calendar.time)
    }


}