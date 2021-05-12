package ru.mitapp.umai.ui.main.main

import android.content.Intent
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
import ru.mitapp.umai.AppUmai.Companion.sharedPreferences
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.MainFragmentBinding
import ru.mitapp.umai.extension.showToast
import ru.mitapp.umai.helper.BaseTextChangeListener
import ru.mitapp.umai.models.auth.SingIn
import ru.mitapp.umai.ui.home.HomeActivity
import ru.mitapp.umai.ui.main.main.adapter.BannerRecyclerAdapter
import ru.mitapp.umai.ui.main.main.viewodel.MainFragmentViewModel
import ru.mitapp.umai.ui.main.register.RegisterActivity
import ru.mitapp.umai.ui.main.restore_password.RestorePasswordActivity
import ru.mitapp.umai.utils.REQUEST_PASSWORD_RESTORE
import java.util.*
import kotlin.collections.ArrayList


class MainFragment : BaseFragment<MainFragmentBinding>(R.layout.main_fragment),
    BannerRecyclerAdapter.Listener {

    private lateinit var viewModel: MainFragmentViewModel
    private lateinit var adapter: BannerRecyclerAdapter
    private var bannerPosition: Int = 0

    private val signIn = SingIn()
    var images: ArrayList<Int> = ArrayList()


    override fun setupView() {
        viewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.connection.observe(this, androidx.lifecycle.Observer {
            connection = it
        })

        images.add(R.drawable.banner_1)
        images.add(R.drawable.banner_2)
        images.add(R.drawable.banner_3)

        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding!!.bannerRecycler)

        binding.bannerRecycler.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        adapter = BannerRecyclerAdapter(images, this)
        binding.bannerRecycler.adapter = adapter

        setupOnboardingIndicators()
        setCurrentIndicator(0)

        binding.bannerRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                recyclerView.layoutManager?.let { layoutManager ->
                    bannerPosition =
                        (layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
                    setCurrentIndicator(bannerPosition)

                }
            }
        })


        signIn()


        binding.forgotPassword.setOnClickListener {
            checkInternet{
                val intent = Intent(requireContext(), RestorePasswordActivity::class.java)
                startActivityForResult(intent, REQUEST_PASSWORD_RESTORE)
            }

        }


        binding.textRegister.setOnClickListener {
            checkInternet {
                startActivity(Intent(requireContext(), RegisterActivity::class.java))
            }
        }

        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                if (adapter.itemCount - 1 == bannerPosition) {
                    binding.bannerRecycler.smoothScrollToPosition(0)
                } else {
                    binding.bannerRecycler.smoothScrollToPosition(bannerPosition + 1)
                }
            }
        }, 0, 5000)



        binding.loginButton.setOnClickListener {
            checkInternet {
                val phone = binding.loginInput.text.toString().trim()
                val password = binding.edtPassword.text.toString().trim()
                setSignIn(phone,password)
                viewModel.singInUser(signIn)
            }

        }
        setInputs()
    }

    override fun onBannerClick() {

    }

    fun setInputs() {
        binding!!.loginInput.addTextChangedListener(object : BaseTextChangeListener() {
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })
        binding!!.edtPassword.addTextChangedListener(object : BaseTextChangeListener() {
            override fun afterTextChanged(p1: Editable?) {
                super.afterTextChanged(p1)
                checkInputs()
            }
        })
    }

    fun checkInputs() {
        viewModel.checkInputs(binding!!.loginInput.text.toString(), binding!!.edtPassword.text.toString().trim())
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



    private fun setSignIn(phone: String, password: String){
        val replacePhone = phone.replace("+", "").replace("(", "")
            .replace(")", "")
            .replace("-", "")
        signIn.phone = replacePhone
        signIn.password = password
        signIn.noCaptcha = true
    }

    private fun signIn(){
        viewModel.singIn.observe(this, androidx.lifecycle.Observer {
            if (it.data!=null){
                val intent = Intent(requireContext(), HomeActivity::class.java)
                sharedPreferences.token = it.data!!.token
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                requireActivity().finish()
            }else{
                requireActivity().showToast(it.errorMessage.toString())
            }
        })
    }


}