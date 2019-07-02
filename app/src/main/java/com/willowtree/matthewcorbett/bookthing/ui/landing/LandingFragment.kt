package com.willowtree.matthewcorbett.bookthing.ui.landing

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo.IME_ACTION_DONE
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import com.willowtree.matthewcorbett.bookthing.BookApp
import com.willowtree.matthewcorbett.bookthing.R
import com.willowtree.matthewcorbett.bookthing.di.ViewModelFactory
import com.willowtree.matthewcorbett.bookthing.dismissKeyboard
import javax.inject.Inject

class LandingFragment : Fragment() {
    
    private lateinit var searchText: TextInputEditText
    
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: LandingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.landing_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity?.application as? BookApp)?.appComponent?.inject(this)
        
        searchText = view.findViewById(R.id.search_text)
        searchText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == IME_ACTION_DONE) {
                viewModel.search(searchText.text.toString())
                searchText.clearFocus()
                searchText.dismissKeyboard()
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LandingViewModel::class.java)

        viewModel.getBooks().observe(this, Observer {
            Log.d("BOOKS_LIST", it.toString())
        })
    }
}
