package ru.mitapp.umai.ui.registration.fragment

import android.text.Editable
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.UserAddressNotResidentFragmentBinding
import ru.mitapp.umai.helper.BaseTextChangeListener
import ru.mitapp.umai.models.SpinnerModel
import ru.mitapp.umai.ui.registration.adapter.SpinnerCustomAdapter
import ru.mitapp.umai.ui.registration.listener.IdentificationListener
import ru.mitapp.umai.ui.registration.viewmodel.UserAddressNotResidentViewModel

class UserAddressNotResidentFragment(var listener: IdentificationListener) :
    BaseFragment<UserAddressNotResidentFragmentBinding>(R.layout.user_address_not_resident_fragment){


    private lateinit var viewModel: UserAddressNotResidentViewModel
    var countryList : ArrayList<SpinnerModel> = ArrayList()
    var regionList : ArrayList<SpinnerModel> = ArrayList()
    var districtList : ArrayList<SpinnerModel> = ArrayList()
    var cityList : ArrayList<SpinnerModel> = ArrayList()
    private lateinit var countryAdapter : SpinnerCustomAdapter
    private lateinit var regionSpinnerAdapter : SpinnerCustomAdapter
    private lateinit var districtSpinnerAdapter : SpinnerCustomAdapter
    private lateinit var citySpinnerAdapter : SpinnerCustomAdapter

    override fun setupView() {
        viewModel = ViewModelProvider(this).get(UserAddressNotResidentViewModel::class.java)

        binding!!.viewModel = viewModel

        fillCountryList()
        fillRegionList()
        fillDistrictList()
        fillCityList()

        countryAdapter = SpinnerCustomAdapter(requireActivity(), countryList)
        regionSpinnerAdapter = SpinnerCustomAdapter(requireActivity(), regionList)
        districtSpinnerAdapter = SpinnerCustomAdapter(requireActivity(), districtList)
        citySpinnerAdapter = SpinnerCustomAdapter(requireActivity(), cityList)

        binding!!.countrySpinner.adapter = countryAdapter
        binding!!.regionSpinner.adapter = regionSpinnerAdapter
        binding!!.districtSpinner.adapter = districtSpinnerAdapter
        binding!!.citySpinner.adapter = citySpinnerAdapter

        binding!!.countrySpinner.onItemSelectedListener = spinerListener
        binding!!.regionSpinner.onItemSelectedListener = spinerListener
        binding!!.districtSpinner.onItemSelectedListener = spinerListener
        binding!!.citySpinner.onItemSelectedListener = spinerListener


        binding!!.nextButton.setOnClickListener{
            listener.onNextButtonClick()
        }

        setUpInputs()
    }
    //?????? ???????????????? ???? ?????????????????????????? ??????????
    fun setUpInputs(){

        binding!!.countrySpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View,
                position: Int,
                id: Long
            ) {
                checkInputs()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Here comes when you didnt choose anything from your spinner logic
            }
        }

        binding!!.regionSpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View,
                position: Int,
                id: Long
            ) {
                checkInputs()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Here comes when you didnt choose anything from your spinner logic
            }
        }
        binding!!.districtSpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View,
                position: Int,
                id: Long
            ) {
                checkInputs()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Here comes when you didnt choose anything from your spinner logic
            }
        }
        binding!!.citySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View,
                position: Int,
                id: Long
            ) {
                checkInputs()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Here comes when you didnt choose anything from your spinner logic
            }
        }

        binding!!.streetInput.addTextChangedListener(object : BaseTextChangeListener(){
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })
        binding!!.houseInput.addTextChangedListener(object : BaseTextChangeListener(){
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })
        binding!!.apartmentInput.addTextChangedListener(object : BaseTextChangeListener(){
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })
        binding!!.addressCb.setOnCheckedChangeListener { _, _ ->
            checkInputs()
        }

    }

    fun checkInputs() {
        viewModel.checkInputs(
            binding!!.countrySpinner.selectedItem.toString(),
            binding!!.regionSpinner.selectedItem.toString(),
            binding!!.districtSpinner.selectedItem.toString(),
            binding!!.citySpinner.selectedItem.toString(),
            binding!!.streetInput.text.toString(),
            binding!!.houseInput.text.toString(),
            binding!!.apartmentInput.text.toString(),
            binding!!.addressCb.isChecked
        )
    }

    private fun fillCountryList() {
        countryList.add(SpinnerModel("?????????????? ????????????", 0))
        countryList.add(SpinnerModel("????????????????????", 1))
        countryList.add(SpinnerModel("??????????????????", 2))
        countryList.add(SpinnerModel("????????????", 3))
    }

    private fun fillRegionList() {
        regionList.add(SpinnerModel("?????????????? ??????????????", 0))
        regionList.add(SpinnerModel("?????????????? ??????????????", 1))
        regionList.add(SpinnerModel("???????????? ??????????????", 2))
        regionList.add(SpinnerModel("???????????????? ??????????????", 3))
        regionList.add(SpinnerModel("?????????????? ??????????????", 4))
        regionList.add(SpinnerModel("?????????????????????????? ??????????????", 5))
        regionList.add(SpinnerModel("?????????????????????? ??????????????", 6))
        regionList.add(SpinnerModel("???????????????????? ??????????????", 7))
    }


    private fun fillDistrictList() {
        districtList.add(SpinnerModel("?????????????? ??????????", 0))
        districtList.add(SpinnerModel("?????????????? ??????????????", 1))
        districtList.add(SpinnerModel("???????????? ??????????????", 2))
        districtList.add(SpinnerModel("???????????????? ??????????????", 3))
        districtList.add(SpinnerModel("?????????????? ??????????????", 4))
        districtList.add(SpinnerModel("?????????????????????????? ??????????????", 5))
        districtList.add(SpinnerModel("?????????????????????? ??????????????", 6))
        districtList.add(SpinnerModel("???????????????????? ??????????????", 7))
    }


    private fun fillCityList() {
        cityList.add(SpinnerModel("?????????????? ??????????", 0))
        cityList.add(SpinnerModel("?????????????? ??????????????", 1))
        cityList.add(SpinnerModel("???????????? ??????????????", 2))
        cityList.add(SpinnerModel("???????????????? ??????????????", 3))
        cityList.add(SpinnerModel("?????????????? ??????????????", 4))
        cityList.add(SpinnerModel("?????????????????????????? ??????????????", 5))
        cityList.add(SpinnerModel("?????????????????????? ??????????????", 6))
        cityList.add(SpinnerModel("???????????????????? ??????????????", 7))
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