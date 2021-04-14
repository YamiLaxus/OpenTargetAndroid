package com.phonedev.openstore.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.core.Resource.Failure
import com.phonedev.openstore.domain.PhoneScreenRepo
import kotlinx.coroutines.Dispatchers

class PhoneScreenViewModel(private val repo: PhoneScreenRepo) : ViewModel() {


    fun fetchAllPhones() = liveData(Dispatchers.IO) {

        emit(Resource.Loading())
        try {
            emit(repo.getAllPhones())
        } catch (e: Exception) {

        }
    }
}

class PhoneScreeViewModelFactory(private val repo: PhoneScreenRepo) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(PhoneScreenRepo::class.java).newInstance(repo)
    }

}