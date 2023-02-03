package com.example.kplist.utils

import com.example.kplist.data.models.apiReviewModel.ApiReviewModel
import com.example.kplist.data.models.apiReviewModel.Doc

fun createDoc(
    __v: Int = 1,
    _id: String = "_id",
    author: String = "author",
    authorId: Int = 1,
    date: String = "date",
    id: Int = 1,
    movieId: Int = 1,
    review: String = "review",
    reviewDislikes: Int = 1,
    reviewLikes: Int = 1,
    title: String = "title",
    type: String = "type",
    updatedAt: String = "updatedAt",
    userRating: Double = 1.1
) = Doc(
    __v = __v,
    _id = _id,
    author = author,
    authorId = authorId,
    date = date,
    id = id,
    movieId = movieId,
    review = review,
    reviewDislikes = reviewDislikes,
    reviewLikes = reviewLikes,
    title = title,
    type = type,
    updatedAt = updatedAt,
    userRating = userRating
)

fun createApiReviewModel(
    docs: List<Doc> = listOf(createDoc()),
    limit: Int = 1,
    page: Int = 1,
    pages: Int = 1,
    total: Int = 1
) = ApiReviewModel(
    docs = docs,
    limit = limit,
    page = page,
    pages = pages,
    total = total
)