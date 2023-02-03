package com.example.kplist.utils.apiEntitiesUtils

import com.example.kplist.data.models.apiPreviewModel.*

fun createApiPreviewModel(
    docs: List<Doc> = listOf(createDoc2()),
    limit: Int = 1,
    page: Int = 1,
    pages: Int = 1,
    total: Int = 1
) = ApiPreviewModel(
    docs = docs,
    limit = limit,
    page = page,
    pages = pages,
    total = total
)

fun createDoc2(
    alternativeName: String = "alternativeName",
    color: String = "color",
    description: String = "description",
    enName: Any = "test",
    externalId: ExternalId = createExternalId2(),
    id: Int = 1,
    logo: Logo = createLogo2(),
    movieLength: Int = 1,
    name: String = "name",
    names: List<Name> = listOf(createName2()),
    poster: Poster = createPoster2(),
    rating: Rating = createRating2(),
    releaseYears: List<ReleaseYear> = listOf(createReleaseYear()),
    shortDescription: String = "shortDescription",
    type: String = "type",
    votes: Votes = createVotes2(),
    watchability: Watchability = createWatchability2(),
    year: Int = 1
) = Doc(
    alternativeName = alternativeName,
    color = color,
    description = description,
    enName = enName,
    externalId = externalId,
    id = id,
    logo = logo,
    movieLength = movieLength,
    name = name,
    names = names,
    poster = poster,
    rating = rating,
    releaseYears = releaseYears,
    shortDescription = shortDescription,
    type = type,
    votes = votes,
    watchability = watchability,
    year = year
)

fun createExternalId2(
    _id: String = "_id",
    imdb: String = "imdb",
    kpHD: String = "kpHD",
    tmdb: Int = 1
) = ExternalId(
    _id = _id,
    imdb = imdb,
    kpHD = kpHD,
    tmdb = tmdb
)

fun createItem(
    _id: String = "_id",
    logo: Logo = createLogo2(),
    name: String = "name",
    url: String = "url"
) = Item(
    _id = _id,
    logo = logo,
    name = name,
    url = url
)

fun createLogo2(
    _id: String = "_id",
    url: String = "url"
) = Logo(
    _id = _id,
    url = url
)

fun createName2(
    _id: String = "_id",
    name: String = "name"
) = Name(
    _id = _id,
    name = name
)

fun createPoster2(
    _id: String = "_id",
    previewUrl: String = "previewUrl",
    url: String = "url"
) = Poster(
    _id = _id,
    previewUrl = previewUrl,
    url = url
)

fun createRating2(
    _id: String = "_id",
    await: Double = 1.1,
    filmCritics: Double = 1.1,
    imdb: Double = 1.1,
    kp: Double = 1.1,
    russianFilmCritics: Double = 1.1
) = Rating(
    _id = _id,
    await = await,
    filmCritics = filmCritics,
    imdb = imdb,
    kp = kp,
    russianFilmCritics = russianFilmCritics
)

fun createReleaseYear(
    _id: String = "_id",
    end: Int = 1,
    start: Int = 1
) = ReleaseYear(
    _id = _id,
    end = end,
    start = start
)

fun createVotes2(
    _id: String = "_id",
    await: Int = 1,
    filmCritics: Int = 1,
    imdb: Int = 1,
    kp: Int = 1,
    russianFilmCritics: Int = 1
) = Votes(
    _id = _id,
    await = await,
    filmCritics = filmCritics,
    imdb = imdb,
    kp = kp,
    russianFilmCritics = russianFilmCritics
)

fun createWatchability2(
    _id: String = "_id",
    items: List<Item> = listOf(createItem())
) = Watchability(
    _id = _id,
    items = items
)