package com.willowtree.matthewcorbett.bookthing.api

import com.willowtree.matthewcorbett.bookthing.model.Book

class VolumeRepository(private val bookApi: BookApi, private val mapper: BookMapper) {

    suspend fun getVolumeById(id: String): Book {
        val volume = bookApi.getVolumeById(id)
        return mapper.mapBook(volume)
    }

    suspend fun getVolumesByTerm(query: String): List<Book> {
        val volumes = bookApi.queryVolumesByTerm(query)
        return volumes.items.map { mapper.mapBook(it) }
    }
}