package com.example.kplist.domain

import androidx.lifecycle.LiveData
import javax.inject.Inject

class GetAllPreviewUseCase @Inject constructor (private val repository: Repository) {

    val getAllPreview = repository.allPreview

}