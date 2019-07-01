package com.willowtree.matthewcorbett.bookthing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.willowtree.matthewcorbett.bookthing.api.BookApi
import com.willowtree.matthewcorbett.bookthing.api.image.GlideApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var bookApi: BookApi

    private val image by lazy { findViewById<AppCompatImageView>(R.id.main_image) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as BookApp).appComponent.inject(this)

        GlobalScope.launch(Dispatchers.Main) {
            val results = bookApi.queryVolumesByTerm("thing")
            val queryById = bookApi.getVolumeById("s1gVAAAAYAAJ")
            image.loadUrl(queryById.volumeInfo.imageLinks.large)
        }
    }

    private fun ImageView.loadUrl(url: String?) {
        GlideApp.with(this).load(url).into(this)
    }
}
