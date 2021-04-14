package com.phonedev.openstore.domain

import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.data.model.PhoneModel
import com.phonedev.openstore.data.remote.PhoneScreenDataSource

class PhoneScreenRepoImpl(private val dataSource: PhoneScreenDataSource): PhoneScreenRepo {

    override suspend fun getAllPhones(): Resource<List<PhoneModel>> = dataSource.getAllPhones()

}