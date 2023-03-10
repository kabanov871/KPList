package com.example.kplist.data.models.apiMovieModel

data class ApiMovieModel(
    val ageRating: Int,
    val alternativeName: String,
    val backdrop: Backdrop,
    val budget: Budget,
    val collections: List<Any>,
    val countries: List<Country>?,
    val createDate: String,
    val description: String,
    val distributors: Distributors,
    val enName: Any,
    val externalId: ExternalId,
    val facts: List<Fact>?,
    val fees: Fees,
    val genres: List<Genre>,
    val id: Int,
    val images: Images,
    val imagesInfo: ImagesInfo,
    val lists: List<Any>,
    val logo: Logo,
    val movieLength: Int,
    val name: String,
    val names: List<Name>,
    val persons: List<Person>?,
    val poster: Poster?,
    val premiere: Premiere,
    val productionCompanies: List<ProductionCompany>,
    val rating: Rating?,
    val ratingMpaa: String,
    val releaseYears: List<Any>,
    val seasonsInfo: List<Any>,
    val sequelsAndPrequels: List<SequelsAndPrequel>,
    val shortDescription: String,
    val similarMovies: List<Any>,
    val slogan: String,
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val technology: Technology,
    val ticketsOnSale: Boolean,
    val top10: Any,
    val top250: Int,
    val type: String,
    val typeNumber: Int,
    val updateDates: List<Any>,
    val updatedAt: String,
    val videos: Videos?,
    val votes: Votes,
    val watchability: Watchability,
    val year: Int
)