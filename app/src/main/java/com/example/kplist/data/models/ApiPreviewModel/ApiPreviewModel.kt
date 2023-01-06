package com.example.kplist.data.models.ApiPreviewModel

data class ApiPreviewModel(
    val docs: List<Doc>,
    val limit: Int,
    val page: Int,
    val pages: Int,
    val total: Int
)