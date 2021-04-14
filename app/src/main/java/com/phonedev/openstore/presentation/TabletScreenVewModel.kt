package com.phonedev.openstore.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.phonedev.openstore.core.Resource
import com.phonedev.openstore.domain.PhoneScreenRepo
import com.phonedev.openstore.domain.TabletScreenRepo
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.liveData

class TabletScreenVewModel(private val repo: TabletScreenRepo) : ViewModel() {

    fun fetchAllTabs() = liveData(Dispatchers.IO) {

        emit(Resource.Loading())
        try {
            emit(repo.getAllTablets())
        } catch (e: Exception) {

        }
    }

}

class TabletScreenViewModelFactory(private val repo: TabletScreenRepo) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(TabletScreenRepo::class.java).newInstance(repo)
    }
}