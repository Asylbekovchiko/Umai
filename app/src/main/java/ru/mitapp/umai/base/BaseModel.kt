package ru.mitapp.umai.base

import com.google.gson.annotations.SerializedName

data class BaseModel<T>(
        var data : T? = null,
        var responseCode : Int? = null,
        @SerializedName("message") var errorMessage : String? = null,
        @SerializedName("errors") var errors : ErrorsBase? = null
)