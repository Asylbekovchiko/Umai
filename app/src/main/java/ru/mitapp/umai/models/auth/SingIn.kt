package ru.mitapp.umai.models.auth

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SingIn(
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("password") var password: String? = null,
    @SerializedName("frontend") var frontend: Frontend? = null,
    @SerializedName("noCaptcha") var noCaptcha: Boolean? = null
): Serializable

data class Frontend(
    @SerializedName("version") var version: Float? = null,
    @SerializedName("device") var device: Device? = null
): Serializable

data class Device(
    @SerializedName("platform") var platform: String? = null,
    @SerializedName("version") var version: Float? = null,
    @SerializedName("uuid") var uuid: String? = null,
    @SerializedName("manufacturer") var manufacturer: String? = null
): Serializable