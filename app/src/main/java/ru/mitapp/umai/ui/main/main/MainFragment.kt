package ru.mitapp.umai.ui.main.main

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.android.tools.build.jetifier.core.utils.Log
import ru.mitapp.umai.AppUmai.Companion.sharedPreferences
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.MainFragmentBinding
import ru.mitapp.umai.extension.showToast
import ru.mitapp.umai.helper.BaseTextChangeListener
import ru.mitapp.umai.models.register.CreateUser
import ru.mitapp.umai.ui.home.HomeActivity
import ru.mitapp.umai.ui.main.adapter.BannerRecyclerAdapter
import ru.mitapp.umai.ui.registration.activity.RegistrationStartActivity
import ru.mitapp.umai.ui.web_view.WebViewActivity
import java.util.*
import kotlin.collections.ArrayList


class MainFragment : BaseFragment<MainFragmentBinding>(R.layout.main_fragment),
    BannerRecyclerAdapter.Listener {

    private lateinit var viewModel: MainFragmentViewModel
    private lateinit var adapter: BannerRecyclerAdapter
    private var bannerPosition: Int = 0
    private val user = CreateUser()
    var images: ArrayList<Int> = ArrayList()


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        binding!!.viewModel = viewModel
        images.add(R.drawable.banner_1)
        images.add(R.drawable.banner_2)
        images.add(R.drawable.banner_3)

        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding!!.bannerRecycler)

        binding!!.bannerRecycler.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        adapter = BannerRecyclerAdapter(images, this)
        binding!!.bannerRecycler.adapter = adapter

        setupOnboardingIndicators()
        setCurrentIndicator(0)

        binding!!.bannerRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                recyclerView.layoutManager?.let { layoutManager ->
                    bannerPosition =
                        (layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
                    setCurrentIndicator(bannerPosition)

                }
            }
        })

        binding!!.loginInput.addTextChangedListener(object : BaseTextChangeListener() {
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })

        binding!!.checkbox.setOnCheckedChangeListener { _, _ ->
            checkInputs()
        }


        binding!!.textView9.setOnClickListener {
            startActivity(Intent(requireContext(), HomeActivity::class.java))
        }

        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                if (adapter.itemCount - 1 == bannerPosition) {
                    binding!!.bannerRecycler.smoothScrollToPosition(0)
                } else {
                    binding!!.bannerRecycler.smoothScrollToPosition(bannerPosition + 1)
                }
            }
        }, 0, 5000)


        binding!!.termsOfUse.setOnClickListener {
            WebViewActivity.start(
                requireActivity(),
                "https://play.google.com/store/apps/details?id=kg.bmt.uw",
                getString(R.string.terms_of_use)
            )
        }

        binding!!.loginButton.setOnClickListener {
//            val intent = Intent(activity, RegistrationStartActivity::class.java)
//            startActivity(intent)

            setPhone()
            createUser()
        }
//        if (sharedPreferences.token!=null){
//            val intent = Intent(activity, RegistrationStartActivity::class.java)
//            startActivity(intent)
//        }
        requireContext().showToast("token: ${sharedPreferences.token.toString()}")

    }

    override fun setupView() {

    }

    override fun onBannerClick() {

    }

    fun checkInputs() {
        viewModel.checkInputs(binding!!.loginInput.text.toString(), binding!!.checkbox.isChecked)
    }

    private fun setupOnboardingIndicators() {
        val imageView = arrayOfNulls<ImageView>(adapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in imageView.indices) {
            imageView[i] = ImageView(activity)
            imageView[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireActivity(),
                        R.drawable.onboarding_indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            binding!!.layoutBannerIndicators.addView(imageView[i])
        }

    }

    private fun setCurrentIndicator(index: Int) {
        val chaildCount = binding!!.layoutBannerIndicators.childCount
        for (i in 0 until chaildCount) {
            val imageView = binding!!.layoutBannerIndicators[i] as ImageView
            if (i == index) {
                imageView.setImageResource(R.drawable.onboarding_indicator_active)
            } else {
                imageView.setImageResource(R.drawable.onboarding_indicator_inactive)

            }
        }
    }

    private fun setPhone(){
        val phone = binding!!.loginInput.text.toString()
        val replacePhone = phone.replace("+", "").replace("(", "")
            .replace(")", "")
            .replace("-", "")
        user.name = null
        user.phone = replacePhone
        user.email = null
        user.password = null
        user.noCaptcha = true
    }

    private fun createUser() {
        viewModel.createUser(user)
        viewModel.createUser.observe(requireActivity(), androidx.lifecycle.Observer {
            if (it.data != null){
                requireActivity().showToast("Success")
//                Log.i("SuccessToken", it.data!!.token.toString())
                sharedPreferences.token = it.data!!.token
                if (sharedPreferences.token!=null){
                    val intent = Intent(activity, RegistrationStartActivity::class.java)
                    startActivity(intent)
                }
            }else{
                requireActivity().showToast(it.errorMessage)
            }
        })
    }

}