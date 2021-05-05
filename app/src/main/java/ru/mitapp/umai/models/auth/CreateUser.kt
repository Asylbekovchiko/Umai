package ru.mitapp.umai.models.auth

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CreateUser(
    @SerializedName("name") var name: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("password") var password: String? = null,
    @SerializedName("noCaptcha") var noCaptcha: Boolean? = null
) : Serializable
