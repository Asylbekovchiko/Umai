package ru.mitapp.umai.models.service

import com.google.gson.annotations.SerializedName

data class Service (

    @SerializedName("_id")  var id: String? = null,
    var title: ServiceTitle? = null,
    var description: ServiceTitle? = null
)