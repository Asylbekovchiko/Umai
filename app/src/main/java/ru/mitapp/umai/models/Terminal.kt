package ru.mitapp.umai.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Terminal(
        @SerializedName("_id") var id: String? = null,
        @SerializedName("name") var name: String? = null,
        @SerializedName("address") var address: String? = null,
        @SerializedName("lat") var lat: Double? = null,
        @SerializedName("lng") var lng: Double? = null,
        @SerializedName("class") var cLass: String? = null,
        @SerializedName("type") var type: String? = null,
        @SerializedName("number") var number: Int? = null,
        @SerializedName("deleted") var deleted: Boolean? = null,
        @SerializedName("workingTime") var workingTime: String? = null

):Parcelable