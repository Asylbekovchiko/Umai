package ru.mitapp.umai.models.templates_models

import java.io.Serializable

data class MyTemplate (
    var icon: String? = null,
    var title: String? = null
) : Serializable