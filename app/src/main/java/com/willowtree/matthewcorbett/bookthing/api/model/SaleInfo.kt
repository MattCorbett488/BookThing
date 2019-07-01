package com.willowtree.matthewcorbett.bookthing.api.model

data class SaleInfo(
    val country: String,
    val saleability: String,
    val isEbook: Boolean,
    val buyLink: String)