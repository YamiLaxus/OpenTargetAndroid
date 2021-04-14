package com.phonedev.openstore.data.remote

import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.data.model.CupModel
import com.phonedev.openstore.domain.CupScreenRepo

class CupScreenDataSourceImpl(private val dataSource: CupScreenDataSource) : CupScreenRepo {

    override suspend fun getAllCup(): Resource<List<CupModel>> = dataSource.getAllCup()

}