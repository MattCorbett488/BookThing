package com.willowtree.matthewcorbett.bookthing.di

import com.willowtree.matthewcorbett.bookthing.BuildConfig
import com.willowtree.matthewcorbett.bookthing.api.BookApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

@Module
class ApplicationModule {

    @Provides
    fun providesBookApi(client: OkHttpClient) = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create<BookApi>()

    @Provides
    fun providesHttpClient() = OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .build()
}