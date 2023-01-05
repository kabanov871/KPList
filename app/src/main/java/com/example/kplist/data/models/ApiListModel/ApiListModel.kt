package com.example.kplist.data.models.ApiListModel

data class ApiListModel(
    val docs: List<Doc>,
    val limit: Int,
    val page: Int,
    val pages: Int,
    val total: Int
)