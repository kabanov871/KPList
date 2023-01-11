package com.example.kplist.domain.detailsUseCase

import com.example.kplist.domain.Repository
import javax.inject.Inject

class GetPersonUseCase @Inject constructor (private val repository: Repository) {

    val getPerson = repository.getPerson
}