package ru.mitapp.umai.models.news

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

data class News(
    @SerializedName("_id") var id: String? = null,
    @SerializedName("deleted") var deleted: Boolean? = null,
    @SerializedName("title")var title: String? = null,
    @SerializedName("content")var content: String? = null,
    @SerializedName("createdBy")var createdBy: String? = null,
    @SerializedName("__v")var v: Int? = null,
    @SerializedName("updatedAt")var updatedAt: Date? = null,
    @SerializedName("updatedBy")var updatedBy: String? = null,
    @SerializedName("createdAt")var createdAt: Date? = null
):Serializable
