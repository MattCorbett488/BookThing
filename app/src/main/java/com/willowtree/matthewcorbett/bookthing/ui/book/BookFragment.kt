package com.willowtree.matthewcorbett.bookthing.ui.book


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.willowtree.matthewcorbett.bookthing.R
import com.willowtree.matthewcorbett.bookthing.loadImage
import com.willowtree.matthewcorbett.bookthing.loadImageWithTarget

class BookFragment : Fragment() {

    private val args: BookFragmentArgs by navArgs()

    private lateinit var title: TextView
    private lateinit var description: TextView
    private lateinit var image: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val book = args.book

        title = view.findViewById(R.id.book_title)
        description = view.findViewById(R.id.book_description)
        image = view.findViewById(R.id.book_image)

        title.text = book.title
        description.text = book.description
        image.loadImageWithTarget(book.imageUrl ?: book.thumbnailImageUrl)


    }
}
