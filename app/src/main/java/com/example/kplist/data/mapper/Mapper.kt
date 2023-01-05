package com.example.kplist.data.mapper

import com.example.kplist.data.models.ApiListModel.ApiListModel
import com.example.kplist.data.models.ApiListModel.Doc
import com.example.kplist.domain.ListUseCaseModel
import javax.inject.Inject

class Mapper @Inject constructor() {

    fun mapApiListModelDocToListUseCaseModel(model: Doc) = ListUseCaseModel(
        id = model.id.toString(),
        poster = model.poster.previewUrl,
        name = model.name,
        year = model.year.toString(),
        ratingKp = model.rating.kp.toString(),
        ratingImdb = model.rating.imdb.toString()
    )

    fun mapListDocToUseCaseList(list: List<Doc>) = list.map { mapApiListModelDocToListUseCaseModel(it) }
}