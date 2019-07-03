package com.willowtree.matthewcorbett.bookthing

import android.content.Context.INPUT_METHOD_SERVICE
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.DrawableImageViewTarget
import com.bumptech.glide.request.target.Target


fun View.dismissKeyboard() {
    val imm = context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?
    imm?.hideSoftInputFromWindow(windowToken, 0)
}

fun ImageView.loadImage(url: String?) = Glide.with(this)
    .load(url)
    .centerCrop()
    .into(this)

fun ImageView.loadImageWithTarget(url: String?) = Glide.with(this)
    .load(url)
    .into(DrawableImageViewTarget(this).waitForLayout())

fun ViewGroup.inflateLayout(@LayoutRes layoutRes: Int): View = LayoutInflater.from(context).inflate(layoutRes, this, false)