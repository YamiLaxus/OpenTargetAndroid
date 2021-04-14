package com.phonedev.openstore.domain

import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.data.model.TabletModel

interface TabletScreenRepo {

    suspend fun getAllTablets(): Resource<List<TabletModel>>

}