package ru.mitapp.umai.models.auth

import com.google.gson.annotations.SerializedName

data class PinCode(
    @SerializedName("pinCode") val pinCode: String? = null
)