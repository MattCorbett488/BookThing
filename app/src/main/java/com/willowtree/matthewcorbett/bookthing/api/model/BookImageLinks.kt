package com.willowtree.matthewcorbett.bookthing.api.model

data class BookImageLinks(
    val thumbnail: String?, //for width of ~128px
    val small: String?, //for width of ~300px
    val medium: String?, //for width of ~575px
    val large: String?, //for width of ~800px
    val smallThumbnail: String?, //for width of ~80px
    val extraLarge: String? //for width of ~1280px
)