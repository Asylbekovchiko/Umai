package ru.mitapp.umai.ui.registration.fragment

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.view.View
import androidx.lifecycle.ViewModelProvider
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseFragment
import ru.mitapp.umai.databinding.SelfieWithPassportFragmentBinding
import ru.mitapp.umai.ui.camera.CameraActivity
import ru.mitapp.umai.ui.registration.listener.IdentificationListener
import ru.mitapp.umai.ui.registration.viewmodel.SelfieWithPassportViewModel
import ru.mitapp.umai.utils.SELFIE_REQUEST_CODE
import java.io.File

class SelfieWithPassportFragment(var listener : IdentificationListener) : BaseFragment<SelfieWithPassportFragmentBinding>(R.layout.selfie_with_passport_fragment) {

    private lateinit var viewModelWith: SelfieWithPassportViewModel


    override fun setupView() {
        viewModelWith = ViewModelProvider(this).get(SelfieWithPassportViewModel::class.java)

        binding!!.selfieStartCameraButton.setOnClickListener{
            CameraActivity.start(requireActivity(), true, SELFIE_REQUEST_CODE)
        }

        binding!!.reshootPhotoPhoto.setOnClickListener{
            CameraActivity.start(requireActivity(), true, SELFIE_REQUEST_CODE)
        }


        binding!!.nextButton.setOnClickListener{
            listener.onNextButtonClick()
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            if (requestCode == SELFIE_REQUEST_CODE){
                val imagePath = data?.getStringExtra("image_path")
                val isSelfie = data?.getBooleanExtra("isSelfie", false)
                rate(imagePath, isSelfie!!)
                binding!!.startSelfieContainer.visibility = View.GONE
                binding!!.selfiePreviewContainer.visibility = View.VISIBLE
            }
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

           binding!!.selfieImage.setImageBitmap(rotatedBitmap)
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

}