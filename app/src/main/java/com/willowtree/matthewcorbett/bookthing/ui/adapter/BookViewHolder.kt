package com.willowtree.matthewcorbett.bookthing.ui.adapter

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.willowtree.matthewcorbett.bookthing.R
import com.willowtree.matthewcorbett.bookthing.loadImage
import com.willowtree.matthewcorbett.bookthing.model.Book

class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var image = itemView.findViewById<AppCompatImageView>(R.id.book_image)
    private var title = itemView.findViewById<AppCompatTextView>(R.id.book_title)

    fun bind(book: Book) {
        image.loadImage(book.imageUrl ?: book.thumbnailImageUrl)
        title.text = book.title
    }
}