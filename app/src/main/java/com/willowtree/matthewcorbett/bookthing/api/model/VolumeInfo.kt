package com.willowtree.matthewcorbett.bookthing.api.model

data class VolumeInfo(
    val title: String,
    val subtitle: String,
    val authors: List<String>,
    val publisher: String,
    val publishedDate: String,
    val description: String,
    val industryIdentifiers: List<IndustryIdentifier>?,
    val readingModes: ReadingModes,
    val pageCount: Double,
    val printType: PrintType,
    val maturityRating: String,
    val allowAnonLogging: Boolean,
    val contentVersion: String,
    val panelizationSummary: Any,
    val imageLinks: BookImageLinks,
    val previewLink: String,
    val infoLink: String,
    val canonicalVolumeLink: String
)