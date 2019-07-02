package com.willowtree.matthewcorbett.bookthing

import android.content.Context.INPUT_METHOD_SERVICE
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import com.bumptech.glide.Glide


fun View.dismissKeyboard() {
    val imm = context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?
    imm?.hideSoftInputFromWindow(windowToken, 0)
}

fun ImageView.loadImage(url: String?) = Glide.with(this).load(url).into(this)