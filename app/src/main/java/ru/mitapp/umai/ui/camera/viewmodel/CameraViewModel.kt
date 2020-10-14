package ru.mitapp.umai.ui.camera.viewmodel

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.hardware.Camera
import android.media.ExifInterface
import android.os.Environment
import androidx.lifecycle.MutableLiveData
import ru.mitapp.umai.base.BaseViewModel
import java.io.File
import java.util.*


class CameraViewModel(var callBack: Camera.PictureCallback) : BaseViewModel() {



    val imagePathData : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }


    val rotateImageBitmap : MutableLiveData<Bitmap> by lazy {
        MutableLiveData<Bitmap>()
    }






    fun captureImage(camera: Camera) {
        camera.takePicture(null, null, callBack)
    }


     fun getOutputMediaFile(): File? {

        val root = Environment.getExternalStorageDirectory()
        val dir = File(root.absolutePath + "/Umai")
        dir.mkdirs()

        val image = File(dir, "image_${UUID.randomUUID()}.jpeg")
        val imagePath = image.path
         imagePathData.value = imagePath

        return image
    }


    fun rate(photoPath : String){
        val ei = ExifInterface(photoPath)
        val orientation: Int = ei.getAttributeInt(
            ExifInterface.TAG_ORIENTATION,
            ExifInterface.ORIENTATION_UNDEFINED
        )

        val image = File(photoPath)
        val bmOptions = BitmapFactory.Options()
        val bitmap = BitmapFactory.decodeFile(image.absolutePath, bmOptions)

        var rotatedBitmap: Bitmap? = null
        when (orientation) {
            ExifInterface.ORIENTATION_ROTATE_90 -> rotatedBitmap = rotateImage(bitmap, 90f)
            ExifInterface.ORIENTATION_ROTATE_180 -> rotatedBitmap = rotateImage(bitmap, 180f)
            ExifInterface.ORIENTATION_ROTATE_270 -> rotatedBitmap = rotateImage(bitmap, 270f)
            ExifInterface.ORIENTATION_NORMAL -> rotatedBitmap = bitmap
            else -> rotatedBitmap = bitmap
        }

        rotateImageBitmap.value = rotatedBitmap
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