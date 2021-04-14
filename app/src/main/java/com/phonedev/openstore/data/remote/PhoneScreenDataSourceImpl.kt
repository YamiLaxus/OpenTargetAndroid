package com.phonedev.openstore.data.remote

import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.data.model.PhoneModel
import com.phonedev.openstore.domain.PhoneScreenRepo

class PhoneScreenDataSourceImpl(private val dataSource: PhoneScreenDataSource): PhoneScreenRepo {

    override suspend fun getAllPhones():Resource<List<PhoneModel>> = dataSource.getAllPhones()

}