package com.willowtree.matthewcorbett.bookthing.api.model

data class Volume(
    val kind: String,
    val id: String,
    val etag: String,
    val selfLink: String,
    val volumeInfo: VolumeInfo,
    val layerInfo: LayerInfo,
    val saleInfo: SaleInfo,
    val accessInfo: AccessInfo)