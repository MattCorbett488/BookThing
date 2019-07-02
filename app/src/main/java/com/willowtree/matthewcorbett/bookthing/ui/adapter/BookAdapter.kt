package com.willowtree.matthewcorbett.bookthing.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.willowtree.matthewcorbett.bookthing.R
import com.willowtree.matthewcorbett.bookthing.inflateLayout
import com.willowtree.matthewcorbett.bookthing.model.Book

class BookAdapter(private var books: List<Book>) : RecyclerView.Adapter<BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BookViewHolder(parent.inflateLayout(R.layout.item_book))

    override fun getItemCount() = books.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    fun setBookList(books: List<Book>) {
        this.books = books
        notifyDataSetChanged()
    }
}