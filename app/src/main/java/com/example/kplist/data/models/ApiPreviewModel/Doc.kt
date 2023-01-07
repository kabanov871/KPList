package com.example.kplist.data.models.ApiPreviewModel

data class Doc(
    val alternativeName: String? = null,
    val color: String? = null,
    val description: String? = null,
    val enName: Any,
    val externalId: ExternalId,
    val id: Int? = null,
    val logo: Logo,
    val movieLength: Int? = null,
    val name: String? = null,
    val names: List<Name>,
    val poster: Poster? = null,
    val rating: Rating,
    val releaseYears: List<ReleaseYear>,
    val shortDescription: String? = null,
    val type: String? = null,
    val votes: Votes,
    val watchability: Watchability,
    val year: Int? = null
)