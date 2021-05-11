package ru.mitapp.umai.models.auth

import com.google.gson.annotations.SerializedName

data class NewPassword(
    @SerializedName("pinCode") val pinCode: String? = null,
    @SerializedName("password") val password: String? = null,
    @SerializedName("passwordConfirmation") val confirm: String? = null
)