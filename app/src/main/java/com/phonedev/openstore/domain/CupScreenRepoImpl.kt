package com.phonedev.openstore.domain

import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.data.model.CupModel
import com.phonedev.openstore.data.remote.CupScreenDataSource

class CupScreenRepoImpl(private val dataSource: CupScreenDataSource): CupScreenRepo {
    override suspend fun getAllCup(): Resource<List<CupModel>> = dataSource.getAllCup()


}