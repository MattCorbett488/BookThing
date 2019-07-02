package com.willowtree.matthewcorbett.bookthing.landing

import androidx.lifecycle.*
import com.willowtree.matthewcorbett.bookthing.api.BookApi
import com.willowtree.matthewcorbett.bookthing.api.model.Volume
import kotlinx.coroutines.launch
import javax.inject.Inject

class LandingViewModel @Inject constructor(private val bookApi: BookApi): ViewModel() {
    private val volumes: MutableLiveData<List<Volume>> = MutableLiveData()

    init {
        viewModelScope.launch {
            val books = bookApi.queryVolumesByTerm("Android").items
                .filter { true }
            volumes.value = books
        }
    }

    fun getVolumes(): LiveData<List<Volume>> = volumes
}