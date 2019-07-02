package com.willowtree.matthewcorbett.bookthing.landing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.willowtree.matthewcorbett.bookthing.BookApp
import com.willowtree.matthewcorbett.bookthing.R
import com.willowtree.matthewcorbett.bookthing.api.BookApi
import com.willowtree.matthewcorbett.bookthing.api.image.GlideApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val image by lazy { findViewById<AppCompatImageView>(R.id.main_image) }

    private lateinit var viewModel: LandingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as BookApp).appComponent.inject(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LandingViewModel::class.java)

        viewModel.getVolumes().observe(this, Observer {
            val imageLinks = it.first().volumeInfo.imageLinks

            val url = when {
                imageLinks.extraLarge != null -> imageLinks.extraLarge
                imageLinks.large != null -> imageLinks.large
                imageLinks.medium != null -> imageLinks.medium
                imageLinks.small != null -> imageLinks.small
                imageLinks.thumbnail != null -> imageLinks.thumbnail
                else -> imageLinks.smallThumbnail
            }
            image.loadUrl(url)
        })
    }

    private fun ImageView.loadUrl(url: String?) {
        GlideApp.with(this).load(url).into(this)
    }
}