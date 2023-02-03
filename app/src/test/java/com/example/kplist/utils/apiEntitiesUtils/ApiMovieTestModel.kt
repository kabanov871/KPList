package com.example.kplist.utils.apiEntitiesUtils

import com.example.kplist.data.models.apiMovieModel.*

fun createBackdrop(
    _id: String = "_id",
    previewUrl: String = "previewUrl",
    url: String = "url"
) = Backdrop(
    _id = _id,
    previewUrl = previewUrl,
    url = url
)

fun createBudget(
    _id: String = "_id",
    currency: String = "currency",
    value: Int = 1
) = Budget(
    _id = _id,
    currency = currency,
    value = value
)

fun createCountry(
    name: String = "name"
) = Country(
    name = name
)

fun createDistributors(
    distributor: String = "distributor",
    distributorRelease: String = "distributorRelease"
) = Distributors(
    distributor = distributor,
    distributorRelease = distributorRelease
)

fun createExternalId(
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

fun createFact2(
    spoiler: Boolean = true,
    type: String = "type",
    value: String = "value"
) = Fact(
    spoiler = spoiler,
    type = type,
    value = value
)

fun createFees(
    _id: String = "_id",
    russia: Russia = createRussia(),
    usa: Usa = createUsa(),
    world: World = createWorld()
) = Fees(
    _id = _id,
    russia = russia,
    usa = usa,
    world = world
)

fun createGenre(
    name: String = "name"
) = Genre(
    name = name
)

fun createImages(
    backdropsCount: Int = 1,
    framesCount: Int = 1,
    postersCount: Int = 1
) = Images(
    backdropsCount = backdropsCount,
    framesCount = framesCount,
    postersCount = postersCount
)

fun createImagesInfo(
    _id: String = "_id",
    framesCount: Int = 1
) = ImagesInfo(
    _id = _id,
    framesCount = framesCount
)

fun createLogo(
    _id: String = "_id",
    url: String = "url"
) = Logo(
    _id = _id,
    url = url
)

fun createName(
    name: String = "name"
) = Name(
    name = name
)

fun createPerson(
    enName: String = "enName",
    enProfession: String = "enProfession",
    id: Int = 1,
    name: String = "name",
    photo: String = "photo"
) = Person(
    enName = enName,
    enProfession = enProfession,
    id = id,
    name = name,
    photo = photo
)

fun createPoster(
    _id: String = "_id",
    previewUrl: String = "previewUrl",
    url: String = "url"
) = Poster(
    _id = _id,
    previewUrl = previewUrl,
    url = url
)

fun createPremiere(
    _id: String = "_id",
    bluray: String = "bluray",
    cinema: String = "cinema",
    country: String = "country",
    dvd: String = "dvd",
    russia: String = "russia",
    world: String = "world"
) = Premiere(
    _id = _id,
    bluray = bluray,
    cinema = cinema,
    country = country,
    dvd = dvd,
    russia = russia,
    world = world
)

fun createProductionCompany(
    name: String = "name",
    previewUrl: String = "previewUrl",
    url: String = "url"
) = ProductionCompany(
    name = name,
    previewUrl = previewUrl,
    url = url
)

fun createRating(
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

fun createRussia(
    _id: String = "_id",
    currency: String = "currency",
    value: Int = 1
) = Russia(
    _id = _id,
    currency = currency,
    value = value
)

fun createSequelsAndPrequel(
    _id: String = "_id"
) = SequelsAndPrequel(
    _id = _id
)

fun createSpokenLanguage(
    name: String = "name",
    nameEn: String = "nameEn"
) = SpokenLanguage(
    name = name,
    nameEn = nameEn
)

fun createTechnology(
    _id: String = "_id",
    has3D: Boolean = true,
    hasImax: Boolean = true
) = Technology(
    _id = _id,
    has3D = has3D,
    hasImax = hasImax
)

fun createTrailer(
    _id: String = "_id",
    name: String = "name",
    site: String = "site",
    type: String = "type",
    url: String = "url"
) = Trailer(
    _id = _id,
    name = name,
    site = site,
    type = type,
    url = url
)

fun createUsa(
    _id: String = "_id",
    currency: String = "currency",
    value: Int = 1
) = Usa(
    _id = _id,
    currency = currency,
    value = value
)

fun createVideos(
    _id: String = "_id",
    teasers: List<Any> = listOf("test"),
    trailers: List<Trailer> = listOf(createTrailer())
) = Videos(
    _id = _id,
    teasers = teasers,
    trailers = trailers
)

fun createVotes(
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

fun createWatchability(
    _id: String = "_id",
    items: Any = "test"
) = Watchability(
    _id = _id,
    items = items
)

fun createWorld(
    _id: String = "_id",
    currency: String = "currency",
    value: Long = 1
) = World(
    _id = _id,
    currency = currency,
    value = value
)

fun createApiMovieModel(
    ageRating: Int = 1,
    alternativeName: String = "alternativeName",
    backdrop: Backdrop = createBackdrop(),
    budget: Budget = createBudget(),
    collections: List<Any> = listOf("test"),
    countries: List<Country> = listOf(createCountry()),
    createDate: String = "createDate",
    description: String = "description",
    distributors: Distributors = createDistributors(),
    enName: Any = "test",
    externalId: ExternalId = createExternalId(),
    facts: List<Fact> = listOf(createFact2()),
    fees: Fees = createFees(),
    genres: List<Genre> = listOf(createGenre()),
    id: Int = 1,
    images: Images = createImages(),
    imagesInfo: ImagesInfo = createImagesInfo(),
    lists: List<Any> = listOf("test"),
    logo: Logo = createLogo(),
    movieLength: Int = 1,
    name: String = "name",
    names: List<Name> = listOf(createName()),
    persons: List<Person> = listOf(createPerson()),
    poster: Poster = createPoster(),
    premiere: Premiere = createPremiere(),
    productionCompanies: List<ProductionCompany> = listOf(createProductionCompany()),
    rating: Rating = createRating(),
    ratingMpaa: String = "ratingMpaa",
    releaseYears: List<Any> = listOf("test"),
    seasonsInfo: List<Any> = listOf("test"),
    sequelsAndPrequels: List<SequelsAndPrequel> = listOf(createSequelsAndPrequel()),
    shortDescription: String = "shortDescription",
    similarMovies: List<Any> = listOf("test"),
    slogan: String = "slogan",
    spokenLanguages: List<SpokenLanguage> = listOf(createSpokenLanguage()),
    status: String = "status",
    technology: Technology = createTechnology(),
    ticketsOnSale: Boolean = true,
    top10: Any = "test",
    top250: Int = 1,
    type: String = "type",
    typeNumber: Int = 1,
    updateDates: List<Any> = listOf("test"),
    updatedAt: String = "updatedAt",
    videos: Videos = createVideos(),
    votes: Votes = createVotes(),
    watchability: Watchability = createWatchability(),
    year: Int = 1
) = ApiMovieModel(
    ageRating = ageRating,
    alternativeName = alternativeName,
    backdrop = backdrop,
    budget = budget,
    collections = collections,
    countries = countries,
    createDate = createDate,
    description = description,
    distributors = distributors,
    enName = enName,
    externalId = externalId,
    facts = facts,
    fees = fees,
    genres = genres,
    id = id,
    images = images,
    imagesInfo = imagesInfo,
    lists = lists,
    logo = logo,
    movieLength = movieLength,
    name = name,
    names = names,
    persons = persons,
    poster = poster,
    premiere = premiere,
    productionCompanies = productionCompanies,
    rating = rating,
    ratingMpaa = ratingMpaa,
    releaseYears = releaseYears,
    seasonsInfo = seasonsInfo,
    sequelsAndPrequels = sequelsAndPrequels,
    shortDescription = shortDescription,
    similarMovies = similarMovies,
    slogan = slogan,
    spokenLanguages = spokenLanguages,
    status = status,
    technology = technology,
    ticketsOnSale = ticketsOnSale,
    top10 = top10,
    top250 = top250,
    type = type,
    typeNumber = typeNumber,
    updateDates = updateDates,
    updatedAt = updatedAt,
    videos = videos,
    votes = votes,
    watchability = watchability,
    year = year
)