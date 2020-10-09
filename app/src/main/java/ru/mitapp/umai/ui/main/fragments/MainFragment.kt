package ru.mitapp.umai.ui.main.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.MainFragmentBinding
import ru.mitapp.umai.ui.main.adapter.BannerRecyclerAdapter
import ru.mitapp.umai.ui.main.view_model.MainFragmentViewModel
import java.util.*
import kotlin.collections.ArrayList

class MainFragment : BaseFragment<MainFragmentBinding>(R.layout.main_fragment), BannerRecyclerAdapter.Listener {


    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainFragmentViewModel
    private lateinit var adapter: BannerRecyclerAdapter
    private var bannerPosition : Int = 0

    var images : ArrayList<Int> = ArrayList()


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainFragmentViewModel::class.java)
        images.add(R.drawable.banner_1)
        images.add(R.drawable.banner_2)
        images.add(R.drawable.banner_3)

        val snapHelper : SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.bannerRecycler)

        binding.bannerRecycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        adapter = BannerRecyclerAdapter(images, this)
        binding.bannerRecycler.adapter = adapter

        setupOnboardingIndicators()
        setCurrentIndicator(0)

        binding.bannerRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                recyclerView.layoutManager?.let { layoutManager ->
                    bannerPosition = (layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
                    setCurrentIndicator(bannerPosition)

                }
            }
        })


        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                if (adapter.itemCount - 1 == bannerPosition) {
                    binding.bannerRecycler.smoothScrollToPosition(0)
                } else {
                    binding.bannerRecycler.smoothScrollToPosition(bannerPosition + 1)
                }
            }
        }, 0, 5000)
    }

    override fun init() {

    }

    override fun onBannerClick() {

    }


    private fun setupOnboardingIndicators()  {
        val imageView  = arrayOfNulls<ImageView>(adapter.itemCount)
        val layoutParams : LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(8,0,8,0)
        for (i in imageView.indices){
            imageView[i] = ImageView(activity)
            imageView[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        activity!!,
                        R.drawable.onboarding_indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            binding.layoutBannerIndicators.addView(imageView[i])
        }

    }

    private fun setCurrentIndicator(index : Int){
        val chaildCount = binding.layoutBannerIndicators.childCount
        for (i in 0 until  chaildCount){
            val imageView = binding.layoutBannerIndicators[i] as ImageView
            if (i == index){
                imageView.setImageResource(R.drawable.onboarding_indicator_active)
            } else{
                imageView.setImageResource(R.drawable.onboarding_indicator_inactive)

            }
        }
    }

}