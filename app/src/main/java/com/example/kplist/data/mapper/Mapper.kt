package com.example.kplist.data.mapper

import com.example.kplist.data.models.ApiPreviewModel.Doc
import com.example.kplist.data.models.DbModels.PreviewDbModel
import com.example.kplist.domain.PreviewUseCaseModel
import javax.inject.Inject

class Mapper @Inject constructor() {

    fun mapPreviewDbModelToPreviewUseCaseModel(model: PreviewDbModel) = PreviewUseCaseModel(
        id = model.id,
        poster = model.poster,
        name = model.name,
        year = model.year,
        ratingKp = model.ratingKp,
        ratingImdb = model.ratingImdb
    )

    fun mapListPreviewDbModelToListPreviewUseCaseModel(list: List<PreviewDbModel>) = list.map {
        mapPreviewDbModelToPreviewUseCaseModel(it)
    }
}