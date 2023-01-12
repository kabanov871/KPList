package com.example.kplist.presentation.searchByPerson

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kplist.R
import com.example.kplist.databinding.FragmentPersonBinding
import com.example.kplist.databinding.FragmentSearchByPersonBinding
import com.example.kplist.presentation.Constance
import com.example.kplist.presentation.MyApp
import com.example.kplist.presentation.ViewModelFactory
import com.example.kplist.presentation.persons.PersonAdapter
import com.example.kplist.presentation.persons.PersonViewModel
import com.example.kplist.presentation.search.SearchViewModel
import javax.inject.Inject


class SearchByPersonFragment : Fragment() {

    lateinit var binding: FragmentSearchByPersonBinding
    private lateinit var adapter: SearchByPersonAdapter
    private lateinit var viewModel: SearchByPersonViewModel
    private lateinit var viewModelSearch: SearchViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as MyApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchByPersonBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, viewModelFactory)[SearchByPersonViewModel::class.java]

        viewModelSearch = ViewModelProvider(this, viewModelFactory)[SearchViewModel::class.java]

        binding.rv.layoutManager = GridLayoutManager(context, 2)
        adapter = SearchByPersonAdapter{ movieId: String -> searchMovie(movieId) }
        binding.rv.adapter = adapter

        displayStartSearchByPerson()

        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayStartSearchByPerson(){

        viewModel.getAllPreviewByPerson.observe(viewLifecycleOwner

        ) {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        }

    }

    private fun searchMovie(movieId: String) {
        viewModelSearch.searchMovie(movieId, Constance.TOKEN)
        viewModelSearch.searchReview(movieId)
        findNavController().navigate(R.id.action_searchByPersonFragment_to_movieFragment)
    }
}