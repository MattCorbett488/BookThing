package com.willowtree.matthewcorbett.bookthing.api.model

data class AccessInfo(
    val country: String,
    val viewability: AccessViewability,
    val embeddable: Boolean,
    val publicDomain: Boolean,
    val textToSpeechPermission: TextToSpeechPermissions,
    val epub: BookFormatAvailability,
    val pdf: BookFormatAvailability,
    val webReaderLink: String,
    val accessViewStatus: AccessViewStatus,
    val quoteSharingAllowed: Boolean
)