package com.willowtree.matthewcorbett.bookthing.ui.landing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.willowtree.matthewcorbett.bookthing.api.VolumeRepository
import com.willowtree.matthewcorbett.bookthing.model.Book
import kotlinx.coroutines.launch
import javax.inject.Inject

class LandingViewModel @Inject constructor(private val volumeRepository: VolumeRepository): ViewModel() {
    private val books: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks(): LiveData<List<Book>> = books

    fun search(query: String) {
        viewModelScope.launch {
            val volume = volumeRepository.getVolumesByTerm(query)
                .filter { true }
            books.value = volume
        }
    }
}