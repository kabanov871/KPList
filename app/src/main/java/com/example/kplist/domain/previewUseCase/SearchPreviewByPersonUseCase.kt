package com.example.kplist.domain.previewUseCase

import com.example.kplist.domain.Repository
import javax.inject.Inject

class SearchPreviewByPersonUseCase @Inject constructor (private val repository: Repository) {

    fun searchPreviewByPerson(personId: String) {
        repository.searchPreviewByPerson(personId)
    }
}