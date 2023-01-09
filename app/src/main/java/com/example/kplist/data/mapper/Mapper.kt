package com.example.kplist.data.mapper

import com.example.kplist.data.models.dbModels.PreviewDbModel
import com.example.kplist.domain.modelsUseCase.PreviewUseCaseModel
import javax.inject.Inject

class Mapper @Inject constructor() {

    fun mapPreviewDbModelToPreviewUseCaseModel(model: PreviewDbModel) = PreviewUseCaseModel(
        id = model.movieId,
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