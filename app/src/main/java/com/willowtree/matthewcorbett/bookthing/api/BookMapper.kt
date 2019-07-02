package com.willowtree.matthewcorbett.bookthing.api

import com.willowtree.matthewcorbett.bookthing.api.model.Volume
import com.willowtree.matthewcorbett.bookthing.model.Book

class BookMapper {

    fun mapBook(volume: Volume): Book {
        val info = volume.volumeInfo
        val images = info.imageLinks
        val thumbnailUrl = images?.thumbnail?.let {
            it
        } ?: images?.smallThumbnail
        val imageUrl = when {
            images?.extraLarge != null -> images.extraLarge
            images?.large != null -> images.large
            images?.medium != null -> images.medium
            else -> images?.small
        }

        return Book(
            volume.id,
            info.title,
            info.subtitle,
            info.description,
            info.authors,
            info.publisher,
            info.publishedDate,
            info.pageCount,
            thumbnailUrl,
            imageUrl
        )
    }
}