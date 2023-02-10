package com.example.kplist.data.mapper

import com.example.kplist.data.models.dbModels.*
import com.example.kplist.domain.modelsUseCase.*
import javax.inject.Inject

class Mapper @Inject constructor() {

    private fun mapPreviewDbModelToPreviewUseCaseModel(
        model: PreviewDbModel
    ) = PreviewUseCaseModel(
        id = model.movieId,
        poster = model.poster,
        name = model.name,
        year = model.year,
        ratingKp = model.ratingKp,
        ratingImdb = model.ratingImdb
    )

    fun mapListPreviewDbModelToListPreviewUseCaseModel(
        list: List<PreviewDbModel>
    ) = list.map {
        mapPreviewDbModelToPreviewUseCaseModel(it)
    }

    private fun mapFavoritesPreviewDbModelToFavoritesPreviewUseCaseModel(
        model: FavoritesPreviewDbModel
    ) = FavoritesPreviewUseCaseModel(
            id = model.movieId,
            poster = model.poster,
            name = model.name,
            year = model.year,
            ratingKp = model.ratingKp,
            ratingImdb = model.ratingImdb
        )

    fun mapListFavoritesPreviewDbModelToListFavoritesPreviewUseCaseModel(
        list: List<FavoritesPreviewDbModel>
    ) = list.map {
            mapFavoritesPreviewDbModelToFavoritesPreviewUseCaseModel(it)
        }

    private fun mapPreviewByPersonDbModelToPreviewByPersonUseCaseModel(
        model: PreviewByPersonDbModel
    ) = PreviewByPersonUseCaseModel(
            id = model.id,
            movieId = model.movieId,
            name = model.name,
            description = model.description
        )

    fun mapListPreviewByPersonDbModelToListPreviewByPersonUseCaseModel(
        list: List<PreviewByPersonDbModel>
    ) = list.map {
            mapPreviewByPersonDbModelToPreviewByPersonUseCaseModel(it)
        }

    fun mapMovieDbModelToMovieUseCaseModel(
        model: MovieDbModel?
    ) = model?.let {
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

    private fun mapDetailDbModelToDetailUseCaseModel(
        model: DetailDbModel
    ) = DetailUseCaseModel(
        name = model.name,
        value = model.value
    )

    fun mapListDetailDbModelToListDetailUseCaseModel(
        list: List<DetailDbModel>
    ) = list.map {
        mapDetailDbModelToDetailUseCaseModel(it)
    }

    private fun mapPersonDbModelToPersonUseCaseModel(
        model: PersonDbModel
    ) = PersonUseCaseModel(
        personId = model.personId,
        photo = model.photo,
        name = model.name,
        prof = model.prof
    )

    fun mapListPersonDbModelToListPersonUseCaseModel(
        list: List<PersonDbModel>
    ) = list.map {
        mapPersonDbModelToPersonUseCaseModel(it)
    }

    private fun mapReviewDbModelToReviewUseCaseModel(
        model: ReviewDbModel
    ) = ReviewUseCaseModel(
        review = model.review,
        title = model.title,
        type = model.type,
        author = model.author,
        likes = model.likes,
        dislikes = model.dislikes
    )

    fun mapListReviewDbModelToListReviewUseCaseModel(
        list: List<ReviewDbModel>
    ) = list.map {
        mapReviewDbModelToReviewUseCaseModel(it)
    }
}