package ru.mitapp.umai.ui.registration.fragment

import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.UserAddressResidentFragmentBinding
import ru.mitapp.umai.models.SpinnerModel
import ru.mitapp.umai.ui.registration.adapter.SpinnerCustomAdapter
import ru.mitapp.umai.ui.registration.listener.IdentificationListener
import ru.mitapp.umai.ui.registration.viewmodel.UserAddressResidentViewModel

class UserAddressResidentFragment(var listener: IdentificationListener) : BaseFragment<UserAddressResidentFragmentBinding>(R.layout.user_address_resident_fragment){


    private lateinit var viewModel: UserAddressResidentViewModel
    var regionList : ArrayList<SpinnerModel> = ArrayList()
    var districtList : ArrayList<SpinnerModel> = ArrayList()
    var cityList : ArrayList<SpinnerModel> = ArrayList()
    private lateinit var regionSpinnerAdapter : SpinnerCustomAdapter
    private lateinit var districtSpinnerAdapter : SpinnerCustomAdapter
    private lateinit var citySpinnerAdapter : SpinnerCustomAdapter

    override fun setupView() {
        viewModel = ViewModelProvider(this).get(UserAddressResidentViewModel::class.java)

        fillRegionList()
        fillDistrictList()
        fillCityList()

        regionSpinnerAdapter = SpinnerCustomAdapter(requireActivity(), regionList)
        districtSpinnerAdapter = SpinnerCustomAdapter(requireActivity(), districtList)
        citySpinnerAdapter = SpinnerCustomAdapter(requireActivity(), cityList)

        binding!!.regionSpinner.adapter = regionSpinnerAdapter
        binding!!.districtSpinner.adapter = districtSpinnerAdapter
        binding!!.citySpinner.adapter = citySpinnerAdapter

        binding!!.regionSpinner.onItemSelectedListener = spinerListener
        binding!!.districtSpinner.onItemSelectedListener = spinerListener
        binding!!.citySpinner.onItemSelectedListener = spinerListener

        binding!!.nextButton.setOnClickListener{
            listener.onNextButtonClick()
        }

    }

    private fun fillRegionList() {
        regionList.add(SpinnerModel("Выбрать область", 0))
        regionList.add(SpinnerModel("Чуйская область", 1))
        regionList.add(SpinnerModel("Ошская область", 2))
        regionList.add(SpinnerModel("Нарынска область", 3))
        regionList.add(SpinnerModel("Таласка область", 4))
        regionList.add(SpinnerModel("Жалалабадская область", 5))
        regionList.add(SpinnerModel("Ысыкульская область", 6))
        regionList.add(SpinnerModel("Баткенская область", 7))
    }


    private fun fillDistrictList() {
        districtList.add(SpinnerModel("Выбрать район", 0))
//        districtList.add(SpinnerModel("Чуйская область", 1))
//        districtList.add(SpinnerModel("Ошская область", 2))
//        districtList.add(SpinnerModel("Нарынска область", 3))
//        districtList.add(SpinnerModel("Таласка область", 4))
//        districtList.add(SpinnerModel("Жалалабадская область", 5))
//        districtList.add(SpinnerModel("Ысыкульская область", 6))
//        districtList.add(SpinnerModel("Баткенская область", 7))
    }


    private fun fillCityList() {
        cityList.add(SpinnerModel("Выбрать город", 0))
//        cityList.add(SpinnerModel("Чуйская область", 1))
//        cityList.add(SpinnerModel("Ошская область", 2))
//        cityList.add(SpinnerModel("Нарынска область", 3))
//        cityList.add(SpinnerModel("Таласка область", 4))
//        cityList.add(SpinnerModel("Жалалабадская область", 5))
//        cityList.add(SpinnerModel("Ысыкульская область", 6))
//        cityList.add(SpinnerModel("Баткенская область", 7))
    }


    var spinerListener = object : AdapterView.OnItemSelectedListener{
        override fun onNothingSelected(p0: AdapterView<*>?) {

        }

        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            if (p0!!.selectedItemPosition != 0){
                Toast.makeText(requireActivity(), "${regionList[p0.selectedItemPosition].name} ${regionList[p0.selectedItemPosition].id}", Toast.LENGTH_LONG).show()
            }

        }
    }

}