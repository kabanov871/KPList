package com.example.kplist.data.models.apiPreviewModel

data class ApiPreviewModel(
    val docs: List<Doc>,
    val limit: Int,
    val page: Int,
    val pages: Int,
    val total: Int
)