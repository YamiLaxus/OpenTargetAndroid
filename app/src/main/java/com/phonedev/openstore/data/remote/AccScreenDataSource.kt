package com.phonedev.openstore.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.data.model.AccModel
import kotlinx.coroutines.tasks.await

class AccScreenDataSource {

    suspend fun getAllAcc(): Resource<List<AccModel>>{
        val accList = mutableListOf<AccModel>()
        val querySnapshot = FirebaseFirestore.getInstance().collection("acc").get().await()
        for (acc in querySnapshot.documents){
            acc.toObject(AccModel::class.java)?.let { accL ->
                accList.add(accL)
            }
        }
        return Resource.Success(accList)
    }

}