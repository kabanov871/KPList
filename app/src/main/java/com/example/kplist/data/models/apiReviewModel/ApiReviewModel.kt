package com.example.kplist.data.models.apiReviewModel

data class ApiReviewModel(
    val docs: List<Doc>?,
    val limit: Int,
    val page: Int,
    val pages: Int,
    val total: Int
)