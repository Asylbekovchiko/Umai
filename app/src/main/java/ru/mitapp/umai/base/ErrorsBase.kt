package ru.mitapp.umai.base

import com.google.gson.annotations.SerializedName

data class ErrorsBase(
    @SerializedName("phone") val phone: Errors? = null,
    @SerializedName("captcha") val captcha: Errors? = null
)

data class Errors(
    val name: String? = null,
    val path: String? = null,
    val type: String? = null,
    val message: String? = null
)
