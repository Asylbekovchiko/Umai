package ru.mitapp.umai.base

data class BaseModel<T>(
        var data : T? = null,
        var responseCode : Int? = null,
        var errorMessage : String? = null
)