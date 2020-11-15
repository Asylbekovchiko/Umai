package ru.mitapp.umai.models

data class Terminal (
    var name : String? = null,
    var distance : String? = null,
    var address : String? = null,
    var type : String? = null,
    var lat : Double? = null,
    var lon : Double? = null
)