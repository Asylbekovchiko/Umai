package ru.mitapp.umai.base

import com.google.gson.annotations.SerializedName

data class BaseModel<T>(
        var data : T? = null,
        var responseCode : Int? = null,
        var error : String? = null,
        @SerializedName("errors") var errorMessage : ErrorsBase? = null
)