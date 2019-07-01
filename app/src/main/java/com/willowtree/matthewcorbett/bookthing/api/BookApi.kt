package com.willowtree.matthewcorbett.bookthing.api

import com.willowtree.matthewcorbett.bookthing.api.model.Volume
import com.willowtree.matthewcorbett.bookthing.api.model.VolumeQueryResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookApi {

    @GET("volumes")
    suspend fun queryVolumesByTerm(@Query("q") query: String?): VolumeQueryResponse

    @GET("volumes/{id}")
    suspend fun getVolumeById(@Path("id") id: String): Volume
}