package com.willowtree.matthewcorbett.bookthing.api.model

data class VolumeQueryResponse(
    val kind: String,
    val totalItems: Int,
    val items: List<Volume>
)