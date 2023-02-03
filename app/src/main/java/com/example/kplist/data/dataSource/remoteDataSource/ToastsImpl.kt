package com.example.kplist.data.dataSource.remoteDataSource

import android.app.Application
import android.widget.Toast
import javax.inject.Inject

class ToastsImpl @Inject constructor (private val application: Application): Toasts {

    override fun showToast(message: String) {
        Toast.makeText(application, message, Toast.LENGTH_SHORT).show()
    }
}