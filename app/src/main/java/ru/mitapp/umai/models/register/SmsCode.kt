package ru.mitapp.umai.models.register

import com.google.gson.annotations.SerializedName

data class SmsCode(
    @SerializedName("smsCode") var smsCode: String?
)