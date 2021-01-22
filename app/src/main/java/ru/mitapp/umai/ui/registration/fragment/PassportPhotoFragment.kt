package ru.mitapp.umai.ui.registration.fragment

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.PassportPhotoFragmentBinding
import ru.mitapp.umai.ui.camera.CameraActivity
import ru.mitapp.umai.ui.registration.listener.IdentificationListener
import ru.mitapp.umai.ui.registration.viewmodel.PassportPhotoViewModel
import ru.mitapp.umai.utils.PASSPORT_PHOTO_REQUEST_CODE
import java.io.File

class PassportPhotoFragment(var listener : IdentificationListener) : BaseFragment<PassportPhotoFragmentBinding>(R.layout.passport_photo_fragment) {

    private lateinit var viewModel: PassportPhotoViewModel

    var isFront = false

    override fun setupView() {
        viewModel = ViewModelProvider(this).get(PassportPhotoViewModel::class.java)

        binding.nextButton.setOnClickListener{
            listener.onNextButtonClick()
        }


        binding.passportBackButton.setOnClickListener{
            isFront = false
            CameraActivity.start(requireActivity(), false, PASSPORT_PHOTO_REQUEST_CODE)
        }


        binding.passportFrontButton.setOnClickListener{
            isFront = true
            CameraActivity.start(requireActivity(), false, PASSPORT_PHOTO_REQUEST_CODE)
        }
    }


    private fun rate(photoPath : String?, isFrontCamera : Boolean = false){
        if (!photoPath.isNullOrEmpty()) {
            val image = File(photoPath)
            val bmOptions = BitmapFactory.Options()
            val bitmap = BitmapFactory.decodeFile(image.absolutePath, bmOptions)

            var rotatedBitmap: Bitmap? = null

            rotatedBitmap = if (isFrontCamera) {
                rotateImage(bitmap, 270f)
            } else {
                rotateImage(bitmap, 0f)
            }

            if (isFront) {
                binding.frontPassportImage.setImageBitmap(rotatedBitmap)
                binding.frontPassportImage.visibility = View.VISIBLE
                binding.frontPassportShadow.visibility = View.VISIBLE
            } else {
                binding.backPassportImage.setImageBitmap(rotatedBitmap)
                binding.backPassportImage.visibility = View.VISIBLE
                binding.backPassportShadow.visibility = View.VISIBLE
            }
        }

    }


    private fun rotateImage(source: Bitmap, angle: Float): Bitmap? {
        val matrix = Matrix()
        matrix.postRotate(angle)
        return Bitmap.createBitmap(
            source, 0, 0, source.width, source.height,
            matrix, true
        )
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            if (requestCode == 22){
             val imagePath = data?.getStringExtra("image_path")
                rate(imagePath)
            }
        }
    }

}