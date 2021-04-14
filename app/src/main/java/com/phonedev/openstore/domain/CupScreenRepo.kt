package com.phonedev.openstore.domain

import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.data.model.CupModel


interface CupScreenRepo {
    suspend fun getAllCup(): Resource<List<CupModel>>
}