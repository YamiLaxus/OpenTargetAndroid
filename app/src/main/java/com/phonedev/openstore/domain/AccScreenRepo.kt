package com.phonedev.openstore.domain

import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.data.model.AccModel

interface AccScreenRepo {
    suspend fun getAllAcc(): Resource<List<AccModel>>
}