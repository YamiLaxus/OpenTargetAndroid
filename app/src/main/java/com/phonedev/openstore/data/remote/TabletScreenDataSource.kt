package com.phonedev.openstore.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.data.model.TabletModel
import kotlinx.coroutines.tasks.await

class TabletScreenDataSource {

    suspend fun getAllTablets(): Resource<List<TabletModel>>{
        val tabletList = mutableListOf<TabletModel>()
        val querySnapshot = FirebaseFirestore.getInstance().collection("tablets").get().await()
        for (tablet in querySnapshot.documents){
            tablet.toObject(TabletModel::class.java)?.let { tabletL ->
                tabletList.add(tabletL)
            }
        }
        return Resource.Success(tabletList)
    }

}