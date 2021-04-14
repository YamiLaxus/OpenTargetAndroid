package com.phonedev.openstore.data.remote


import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.data.model.PhoneModel
import com.phonedev.openstore.data.model.TabletModel
import com.phonedev.openstore.domain.TabletScreenRepo

class TabletScreenDataSourceImpl(private val dataSource: TabletScreenDataSource): TabletScreenRepo {

    override suspend fun getAllTablets(): Resource<List<TabletModel>> = dataSource.getAllTablets()

}