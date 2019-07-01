package com.willowtree.matthewcorbett.bookthing.api.model

data class IndustryIdentifier(
    val type: IndustryIdentifierType,
    val identifier: String
)