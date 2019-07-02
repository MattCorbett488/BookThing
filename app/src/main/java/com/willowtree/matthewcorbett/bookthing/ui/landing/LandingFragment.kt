package com.willowtree.matthewcorbett.bookthing.ui.landing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.willowtree.matthewcorbett.bookthing.BookApp
import com.willowtree.matthewcorbett.bookthing.R
import com.willowtree.matthewcorbett.bookthing.di.ViewModelFactory
import javax.inject.Inject

class LandingFragment : Fragment() {

    private val button by lazy { view?.findViewById<AppCompatButton>(R.id.book_button) }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    companion object {
        fun newInstance() = LandingFragment()
    }

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

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LandingViewModel::class.java)

        button?.setOnClickListener {
            val controller = Navigation.findNavController(activity as AppCompatActivity, R.id.nav_host_fragment)
            controller.navigate(R.id.bookFragment)
        }
    }
}
