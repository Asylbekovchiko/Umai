package ru.mitapp.umai.models.service

import com.google.gson.annotations.SerializedName

data class SubCategoryService(
    @SerializedName("label") var name : String? = null,
    @SerializedName("type") var type : String? = null,
    @SerializedName("gateway") var gateway: String? = null,
    @SerializedName("category") var category: String? = null,
    @SerializedName("sequence") var sequence: Int? = null
)