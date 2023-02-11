package com.example.kplist.utils


import com.example.kplist.data.models.dbModels.*


fun createPreviewDbModel(

    id: Int = 1,

    movieId: Int = 1,

    poster: String = "poster",

    name: String = "name",

    year: String = "year",

    ratingKp: Double = 1.1,

    ratingImdb: Double = 1.1

) = PreviewDbModel(

    id= id,

    movieId= movieId,

    poster = poster,

    name = name,

    year = year,

    ratingKp = ratingKp,

    ratingImdb = ratingImdb
)

fun createFavoritesPreviewDbModel(

    id: Int = 1,

    movieId: Int = 1,

    poster: String = "poster",

    name: String = "name",

    year: String = "year",

    ratingKp: Double = 1.1,

    ratingImdb: Double = 1.1

) = FavoritesPreviewDbModel(

    id = id,

    movieId = movieId,

    poster = poster,

    name = name,

    year = year,

    ratingKp = ratingKp,

    ratingImdb = ratingImdb
)

fun createMovieDbModel(

    id: Int = 1,

    movieId: Int = 1,

    poster: String = "poster",

    name: String = "poster",

    description: String = "description",

    year: String = "year",

    ratingKp: Double = 1.1,

    ratingImdb: Double = 1.1,

    ratingCritic: Double = 1.1

) = MovieDbModel(

    id = id,

    movieId = movieId,

    poster = poster,

    name = poster,

    description = description,

    year = year,

    ratingKp = ratingKp,

    ratingImdb = ratingImdb,

    ratingCritic = ratingCritic

)

fun createPersonDbModel(

    id: Int = 1,

    personId: Int = 1,

    photo: String = "photo",

    name: String = "name",

    prof: String = "prof"

) = PersonDbModel(

    id = id,

    personId = personId,

    photo = photo,

    name = name,

    prof = prof

)

fun createPreviewByPersonDbModel(

    id: Int = 1,

    movieId: Int = 1,

    name: String = "name",

    description: String = "description"

) = PreviewByPersonDbModel(

    id = id,

    movieId = movieId,

    name = name,

    description = description

)

fun createReviewDbModel(

    id: Int = 1,

    review: String = "review",

    title: String = "title",

    type: String = "type",

    author: String = "author",

    likes: Int = 1,

    dislikes: Int = 1

) = ReviewDbModel(

    id = id,

    review = review,

    title = title,

    type = type,

    author = author,

    likes = likes,

    dislikes = dislikes

)

fun createDetailDbModel(

    id: Int = 1,

    name: String = "name",

    value: String = "value"

) = DetailDbModel(

    id = id,

    name = name,

    value = value

)