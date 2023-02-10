package com.example.kplist.domain.previewUseCase

import com.example.kplist.domain.Repository
import javax.inject.Inject

class GetAllPreviewByPersonUseCase @Inject constructor(private val repository: Repository) {

    val getAllPreviewByPerson = repository.allPreviewByPerson
}