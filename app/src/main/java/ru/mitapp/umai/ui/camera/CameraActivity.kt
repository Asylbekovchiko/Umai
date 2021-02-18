package ru.mitapp.umai.ui.camera

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.hardware.Camera
import android.hardware.Camera.CameraInfo
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import ru.mitapp.umai.R
import ru.mitapp.umai.base.BaseActivity
import ru.mitapp.umai.databinding.ActivityCameraBinding
import ru.mitapp.umai.extension.showToast
import ru.mitapp.umai.ui.camera.viewmodel.CameraViewModel
import java.io.FileOutputStream


class CameraActivity : BaseActivity<ActivityCameraBinding>(R.layout.activity_camera),
    Camera.PictureCallback {

    private var camera: Camera? = null
    private lateinit var showCamera: ShowCamera
    private var imagePath: String = ""
    private var isPicture = false
    private var isCamera = true
    private var hasCamera = false
    private var isFrontCamera = false
    private var cameraId = -1
    private val isSelfie : Boolean?
    get() = intent.getBooleanExtra("is_selfie", false)

    private lateinit var viewModel: CameraViewModel


    override fun setupView() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        if (isSelfie!!){
            binding.maskView.setBackgroundResource(R.drawable.ic_front_camera_mask)
            binding.doneButton.visibility = View.GONE
            cameraId = getFrontCameraId()
        } else{
            binding.maskView.setBackgroundResource(R.drawable.ic_bg_camera)
            cameraId = getBackCameraId()
        }
        camera = Camera.open(cameraId)
        showCamera = ShowCamera(this, camera!!)
        binding.cameraContainer.addView(showCamera)

        viewModel = CameraViewModel(this)

        binding.cameraButton.setOnClickListener {
            if (isCamera) {
                if (camera != null) {
                    viewModel.captureImage(camera!!)
                }
            } else {
                val intent = Intent()
                intent.putExtra("image_path", imagePath)
                intent.putExtra("isSelfie", isSelfie!!)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }


        viewModel.imagePathData.observe(this, Observer {
            imagePath = it
        })


        viewModel.rotateImageBitmap.observe(this, Observer {
            setupImage(it)
        })


        binding.closeButton.setOnClickListener {
            if (isPicture) {
                binding.cameraContainer.visibility = View.VISIBLE
                binding.maskView.visibility = View.VISIBLE
                binding.image.visibility = View.GONE
                binding.cameraButton.setImageResource(R.drawable.ic_camera_button)
                isCamera = true
                isPicture = false
            } else {
                finish()
            }
        }


        binding.doneButton.setOnClickListener {
            if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
                cameraId = if (isFrontCamera){
                    getBackCameraId()
                } else{
                    getFrontCameraId()
                }


                hasCamera = cameraId != -1
            } else {
                hasCamera = false
            }

            getCameraInstance()
        }
    }


    companion object {
        fun start(activity: Activity, isSelfie : Boolean = false, requestCode : Int) {
            val intent = Intent(activity, CameraActivity::class.java)
            intent.putExtra("is_selfie", isSelfie)
            activity.startActivityForResult(intent, requestCode)
        }
    }


    override fun onPictureTaken(data: ByteArray?, camera: Camera?) {
        val pictureFile = viewModel.getOutputMediaFile()

        if (pictureFile == null) {
            return
        } else {
            try {
                val fos = FileOutputStream(pictureFile)
                fos.write(data)
                fos.close()
                camera!!.startPreview()
                viewModel.rate(imagePath, isFrontCamera)
            } catch (e: Exception) {
                e.stackTrace
                showToast(e.message.toString())
            }
        }
    }

    fun hasCamera(): Boolean {
        return hasCamera
    }

    fun getCameraInstance() {
        releaseCamera()
        camera = null
        if (hasCamera) {
            try {
                Handler().postDelayed({
                    camera = Camera.open(cameraId)
                    showCamera = ShowCamera(this, camera!!)
                    binding.cameraContainer.addView(showCamera)
                }, 200)



            } catch (e: java.lang.Exception) {
            }
        }
    }

    fun releaseCamera() {
        if (camera != null) {
            camera!!.release()
            camera = null
        }
    }

    private fun getFrontCameraId(): Int {
        var camId = -1
        val numberOfCameras = Camera.getNumberOfCameras()
        val ci = CameraInfo()
        for (i in 0 until numberOfCameras) {
            Camera.getCameraInfo(i, ci)
            if (ci.facing == CameraInfo.CAMERA_FACING_FRONT) {
                camId = i
                isFrontCamera = true
            }
        }
        return camId
    }

    private fun getBackCameraId(): Int {
        var camId = -1
        val numberOfCameras = Camera.getNumberOfCameras()
        val ci = CameraInfo()
        for (i in 0 until numberOfCameras) {
            Camera.getCameraInfo(i, ci)
            if (ci.facing == CameraInfo.CAMERA_FACING_BACK) {
                camId = i
                isFrontCamera = false
            }
        }
        return camId
    }

    private fun setupImage(bitmap: Bitmap) {
       /* Glide.with(this).load(imagePath).into(binding.image)*/
        binding.image.setImageBitmap(bitmap)
        isPicture = true
        binding.cameraButton.setImageResource(R.drawable.ic_done)
        isCamera = false
        binding.cameraContainer.visibility = View.GONE
        binding.maskView.visibility = View.GONE
        binding.image.visibility = View.VISIBLE

    }

    override fun onResume() {
        super.onResume()
        cameraId = if (isSelfie!!){
            getFrontCameraId()
        } else{
            getBackCameraId()
        }
        if (cameraId != -1) {
            camera = Camera.open(cameraId)
            showCamera = ShowCamera(this, camera!!)
            binding.cameraContainer.addView(showCamera)
        }


    }

}