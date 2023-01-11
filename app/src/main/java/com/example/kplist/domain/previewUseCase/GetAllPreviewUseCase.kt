package com.example.kplist.domain.previewUseCase

import com.example.kplist.domain.Repository
import javax.inject.Inject

class GetAllPreviewUseCase @Inject constructor (private val repository: Repository) {

    val getAllPreview = repository.allPreview

}