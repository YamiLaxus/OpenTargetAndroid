package com.phonedev.openstore.domain


import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.data.model.TabletModel
import com.phonedev.openstore.data.remote.PhoneScreenDataSource
import com.phonedev.openstore.data.remote.TabletScreenDataSource

class TabletScreenRepoImpl(private val dataSource: TabletScreenDataSource): TabletScreenRepo {

    override suspend fun getAllTablets(): Resource<List<TabletModel>> = dataSource.getAllTablets()


}