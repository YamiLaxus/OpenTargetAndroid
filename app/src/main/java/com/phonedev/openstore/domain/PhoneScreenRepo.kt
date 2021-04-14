package com.phonedev.openstore.domain

import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.data.model.PhoneModel

interface PhoneScreenRepo {

    suspend fun getAllPhones(): Resource<List<PhoneModel>>

}