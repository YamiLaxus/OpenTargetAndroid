package com.phonedev.openstore.data.remote

import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.data.model.AccModel
import com.phonedev.openstore.domain.AccScreenRepo

class AccScreenDataSourceImpl(private val dataSource: AccScreenDataSource): AccScreenRepo {

    override suspend fun getAllAcc(): Resource<List<AccModel>> = dataSource.getAllAcc()

}