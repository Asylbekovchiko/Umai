package ru.mitapp.umai.extension

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast


fun Activity.isPermissionWrite() : Boolean{
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        return if (this.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            }
            requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 23)
            false
        } else {
            true
        }

    }

    return true
}


fun Context.showToast(message : String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}


 fun Activity.hasCameraPermission(): Boolean? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if (this.checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(
                arrayOf(Manifest.permission.CAMERA),
                23
            )
            false
        } else {
            isPermissionWrite()
            true
        }
    } else {
        true
    }
}