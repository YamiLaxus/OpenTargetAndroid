package com.phonedev.openstore.presentation

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.domain.AccScreenRepo
import kotlinx.coroutines.Dispatchers

class AccScreenViewHolder(private val repo: AccScreenRepo) : ViewModel() {

    fun fetchAllAcc() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getAllAcc())
        } catch (e: Exception) {

        }
    }
}

class AccScreenViewModelFactory(private val repo: AccScreenRepo) :
        ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(AccScreenRepo::class.java).newInstance(repo)
    }

}