package ru.mitapp.umai.models.service

import com.google.gson.annotations.SerializedName

data class ServiceTitle(
    @SerializedName("ru")
    var ru: String? = null,
    @SerializedName("kg")
    var kg: String? = null
)