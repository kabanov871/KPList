package com.example.kplist.domain.detailsUseCase

import com.example.kplist.domain.Repository
import javax.inject.Inject

class GetPerson @Inject constructor (private val repository: Repository) {

    val getPerson = repository.getPerson
}