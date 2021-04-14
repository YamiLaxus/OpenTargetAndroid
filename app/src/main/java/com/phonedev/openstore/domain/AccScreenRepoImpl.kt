package com.phonedev.openstore.domain

import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.data.model.AccModel
import com.phonedev.openstore.data.remote.AccScreenDataSource

class AccScreenRepoImpl(private val dataSource: AccScreenDataSource): AccScreenRepo {

    override suspend fun getAllAcc(): Resource<List<AccModel>> = dataSource.getAllAcc()

}