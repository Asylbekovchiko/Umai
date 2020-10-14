package ru.mitapp.umai.ui.camera

import android.content.Context
import android.content.res.Configuration
import android.hardware.Camera
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.io.IOException

class ShowCamera(context: Context, var camera: Camera) : SurfaceView(context),
    SurfaceHolder.Callback {

    private var surfaceHolder: SurfaceHolder = holder

    init {
        surfaceHolder.addCallback(this)
    }

    override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        camera.stopPreview()
        camera.release()
    }

    override fun surfaceCreated(p0: SurfaceHolder) {
        val params: Camera.Parameters = camera.parameters
        val sizes: List<Camera.Size> = params.supportedPictureSizes
        var mSize: Camera.Size? = null
        for (size in sizes) {
            mSize = size
        }


        if (this.resources.configuration.orientation != Configuration.ORIENTATION_LANDSCAPE) {
            params.set("orientation", "portrait")
            camera.setDisplayOrientation(90)
            params.setRotation(90)
        } else {
            params.set("orientation", "landscape")
            camera.setDisplayOrientation(90)
            params.setRotation(90)
        }

        // AutoFocus
        params.focusMode = "continuous-picture"
        params.focusMode = Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE

        camera.parameters = params

        if (mSize != null)
            params.setPictureSize(mSize.width, mSize.height)

        try {
            camera.setPreviewDisplay(holder)
            camera.startPreview()

        } catch (e: IOException) {
            e.printStackTrace()
        }

    }
}