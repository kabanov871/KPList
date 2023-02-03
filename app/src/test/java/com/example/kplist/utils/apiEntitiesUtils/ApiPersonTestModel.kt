package com.example.kplist.utils.apiEntitiesUtils

import com.example.kplist.data.models.apiPersonModel.*

fun createApiPersonModel(
    __v: Int = 1,
    age: Int = 1,
    birthPlace: List<BirthPlace> = listOf(createBirthPlace()),
    birthday: String = "birthday",
    countAwards: Int = 1,
    createdAt: String = "createdAt",
    death: Any = "test",
    deathPlace: List<Any> = listOf("test"),
    enName: String = "enName",
    facts: List<Fact> = listOf(createFact()),
    growth: Int = 1,
    id: Int = 1,
    movies: List<Movy> = listOf(createMovy()),
    name: String = "name",
    photo: String = "photo",
    profession: List<Profession> = listOf(createProfession()),
    sex: String = "sex",
    spouses: List<Any> = listOf("test"),
    updatedAt: String = "updatedAt"
) = ApiPersonModel(
    __v = __v,
    age = age,
    birthPlace = birthPlace,
    birthday = birthday,
    countAwards = countAwards,
    createdAt = createdAt,
    death = death,
    deathPlace = deathPlace,
    enName = enName,
    facts = facts,
    growth = growth,
    id = id,
    movies = movies,
    name = name,
    photo = photo,
    profession = profession,
    sex = sex,
    spouses = spouses,
    updatedAt = updatedAt
)

fun createBirthPlace(
    value: String = "value"
) = BirthPlace(
    value = value
)

fun createFact(
    value: String = "value"
) = Fact(
    value = value
)

fun createMovy(
    description: String = "description",
    general: Boolean = true,
    id: Int = 1,
    name: String = "name",
    rating: Double = 1.1
) = Movy(
    description = description,
    general = general,
    id = id,
    name = name,
    rating = rating
)

fun createProfession(
    value: String = "value"
) = Profession(
    value = value
)