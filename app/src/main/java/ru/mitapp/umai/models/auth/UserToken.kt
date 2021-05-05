package ru.mitapp.umai.models.auth

import com.google.gson.annotations.SerializedName

data class UserToken(
    @SerializedName("token") var token: String? = null
)
