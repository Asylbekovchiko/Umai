package ru.mitapp.umai.models.history

data class HistoryModel(
    var icon : String? = null,
    var date: String? = null,
    var title: String? = null,
    var account: String? = null,
    var detailDate: String? = null,
    var totalSum: String? = null,
    var status: String? = null,
    var operationType: String? = null
)