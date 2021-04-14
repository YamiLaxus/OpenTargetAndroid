package com.phonedev.openstore.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.domain.CupScreenRepo
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class CupScreenViewModel(private val repo: CupScreenRepo) : ViewModel() {

    fun fetchAllCup() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getAllCup())
        } catch (e: Exception) {

        }
    }
}

class CupScreenViewModelFactory(private val repo: CupScreenRepo) :
        ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(CupScreenRepo::class.java).newInstance(repo)
    }

}