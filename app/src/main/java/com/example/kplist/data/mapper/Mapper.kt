package com.example.kplist.data.mapper

import com.example.kplist.data.models.dbModels.DetailDbModel
import com.example.kplist.data.models.dbModels.MovieDbModel
import com.example.kplist.data.models.dbModels.PersonDbModel
import com.example.kplist.data.models.dbModels.PreviewDbModel
import com.example.kplist.domain.modelsUseCase.DetailUseCaseModel
import com.example.kplist.domain.modelsUseCase.MovieUseCaseModel
import com.example.kplist.domain.modelsUseCase.PersonUseCaseModel
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

    fun mapMovieDbModelToMovieUseCaseModel(model: MovieDbModel?) = model?.let {
        MovieUseCaseModel(
        movieId = it.movieId,
        poster = model.poster,
        name = model.name,
        description = model.description,
        year = model.year,
        ratingKp = model.ratingKp,
        ratingImdb = model.ratingImdb,
        ratingCritic = model.ratingCritic
    )
    }

    fun mapDetailDbModelToDetailUseCaseModel(model: DetailDbModel) = DetailUseCaseModel(
        name = model.name,
        value = model.value
    )

    fun mapListDetailDbModelToListDetailUseCaseModel(list: List<DetailDbModel>) = list.map {
        mapDetailDbModelToDetailUseCaseModel(it)
    }

    fun mapPersonDbModelToPersonUseCaseModel(model: PersonDbModel) = PersonUseCaseModel(
        personId = model.personId,
        photo = model.photo,
        name = model.name,
        prof = model.prof
    )

    fun mapListPersonDbModelToListPersonUseCaseModel(list: List<PersonDbModel>) = list.map {
        mapPersonDbModelToPersonUseCaseModel(it)
    }
}