package ru.mitapp.umai.ui.main.fragments

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.mitapp.umai.R
import ru.mitapp.umai.databinding.TerminalMapFragmentBinding
import ru.mitapp.umai.models.Terminal
import ru.mitapp.umai.ui.main.view_model.TerminalMapViewModel


class TerminalMapFragment(var listener: TerminalListener, var terminals: ArrayList<Terminal>) :
    Fragment(), OnMapReadyCallback {


    lateinit var mapFragment: SupportMapFragment
    lateinit var binding: TerminalMapFragmentBinding
    private lateinit var viewModel: TerminalMapViewModel
    private lateinit var mMap: GoogleMap
    private var mapReady = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.terminal_map_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(TerminalMapViewModel::class.java)

        mapFragment = childFragmentManager.findFragmentById(R.id.terminal_map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        return binding.root
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap!!
        mapReady = true

        for (items in terminals) {
            val location1 = LatLng(items.lat!!, items.lng!!)
            val marker = MarkerOptions().position(location1).title(items.name)
            when (items.type) {
                "terminal" -> marker.icon(
                    bitmapDescriptorFromVector(
                        requireContext(),
                        R.drawable.ic_atm_marker
                    )
                )
                "bank" -> marker.icon(
                    bitmapDescriptorFromVector(
                        requireContext(),
                        R.drawable.ic_bank_marker
                    )
                )
                "office" -> marker.icon(
                    bitmapDescriptorFromVector(
                        requireContext(),
                        R.drawable.ic_ofice_marker
                    )
                )
            }

            mMap.addMarker(marker)
        }

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(42.871444, 74.582129), 17f))

        mMap.setOnMarkerClickListener { marker ->
            marker.title


            for (ter in terminals) {
                if (ter.name == marker.title) {
                    Log.d("atms", ter.toString())
                    break
                }
            }



            true
        }


    }


    private fun bitmapDescriptorFromVector(
        context: Context,
        vectorResId: Int
    ): BitmapDescriptor? {
        val vectorDrawable: Drawable? = ContextCompat.getDrawable(context, vectorResId)
        vectorDrawable?.setBounds(
            0,
            0,
            vectorDrawable.intrinsicWidth,
            vectorDrawable.intrinsicHeight
        )
        val bitmap = Bitmap.createBitmap(
            vectorDrawable!!.intrinsicWidth,
            vectorDrawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }


}