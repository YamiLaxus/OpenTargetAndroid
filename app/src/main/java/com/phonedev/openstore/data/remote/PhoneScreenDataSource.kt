package com.phonedev.openstore.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.data.model.PhoneModel
import kotlinx.coroutines.tasks.await

class PhoneScreenDataSource {

    suspend fun getAllPhones(): Resource<List<PhoneModel>>{
        val phoneList = mutableListOf<PhoneModel>()
        val querySnapshot = FirebaseFirestore.getInstance().collection("celulares").get().await()
        for(phone in querySnapshot.documents){
            phone.toObject(PhoneModel::class.java)?.let { phoneL ->
                phoneList.add(phoneL)
            }
        }
        return Resource.Success(phoneList)
    }


}