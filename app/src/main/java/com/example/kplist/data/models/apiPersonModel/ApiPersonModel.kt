package com.example.kplist.data.models.apiPersonModel

data class ApiPersonModel(
    val __v: Int,
    val age: Int,
    val birthPlace: List<BirthPlace>,
    val birthday: String,
    val countAwards: Int,
    val createdAt: String,
    val death: Any,
    val deathPlace: List<Any>,
    val enName: String,
    val facts: List<Fact>,
    val growth: Int,
    val id: Int,
    val movies: List<Movy>,
    val name: String,
    val photo: String,
    val profession: List<Profession>,
    val sex: String,
    val spouses: List<Any>,
    val updatedAt: String
)