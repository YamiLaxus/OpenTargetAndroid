package com.phonedev.openstore.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.data.model.CupModel
import kotlinx.coroutines.tasks.await

class CupScreenDataSource {

    suspend fun getAllCup(): Resource<List<CupModel>>{
        val cupList = mutableListOf<CupModel>()
        val querySnapshot = FirebaseFirestore.getInstance().collection("cup").get().await()
        for (cup in querySnapshot.documents){
            cup.toObject(CupModel::class.java)?.let { cupL ->
                cupList.add(cupL)
            }
        }
        return Resource.Success(cupList)
    }
}