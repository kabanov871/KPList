package com.example.kplist.data.repositoryImpl

import com.example.kplist.data.mapper.Mapper
import com.example.kplist.data.network.ApiInterface
import com.example.kplist.domain.ListUseCaseModel
import com.example.kplist.domain.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class RepositoryImpl @Inject constructor (
    private val mapper: Mapper,
    private val api: ApiInterface
        ): Repository{

    override fun getList(genres: String, sort: String): List<ListUseCaseModel> {

        val list = ArrayList<ListUseCaseModel>()

        CoroutineScope(Dispatchers.IO).launch {

            api.getList(genres, sort).let {

                if (it.isSuccessful) {

                    list.clear()
                    list.addAll(mapper.mapListDocToUseCaseList(it.body()!!.docs))
                }
            }
        }
        return list
    }

}