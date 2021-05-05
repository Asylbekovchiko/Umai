package ru.mitapp.umai.models.auth

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SingIn(
    @SerializedName("phone") val phone: String? = null,
    @SerializedName("password") val password: String? = null,
    @SerializedName("frontend") val frontend: Frontend? = null,
    @SerializedName("noCaptcha") var noCaptcha: Boolean? = null
): Serializable

data class Frontend(
    @SerializedName("version") val version: Float? = null,
    @SerializedName("device") val device: Device? = null
): Serializable

data class Device(
    @SerializedName("platform") val platform: String? = null,
    @SerializedName("version") val version: Float? = null,
    @SerializedName("uuid") val uuid: String? = null,
    @SerializedName("manufacturer") val manufacturer: String? = null
): Serializable