package com.willowtree.matthewcorbett.bookthing.model

data class Book(
    val id: String,
    val title: String,
    val subtitle: String? = null,
    val description: String?,
    val authors: List<String>?,
    val publisher: String?,
    val publishedDate: String?,
    val pageCount: Double?,
    val thumbnailImageUrl: String?,
    val imageUrl: String?
)