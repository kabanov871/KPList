package com.example.kplist.presentation.favorites

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
import com.example.kplist.databinding.FragmentFavouritesBinding
import com.example.kplist.presentation.Constance
import com.example.kplist.presentation.MyApp
import com.example.kplist.presentation.ViewModelFactory
import com.example.kplist.presentation.search.SearchAdapter
import com.example.kplist.presentation.search.SearchViewModel
import javax.inject.Inject

class FavouritesFragment : Fragment() {

    lateinit var binding: FragmentFavouritesBinding
    lateinit var adapter: FavoritesAdapter
    private lateinit var viewModel: FavoritesViewModel
    private lateinit var searchViewModel: SearchViewModel

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
        binding = FragmentFavouritesBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, viewModelFactory)[FavoritesViewModel::class.java]

        searchViewModel = ViewModelProvider(this, viewModelFactory)[SearchViewModel::class.java]

        binding.rw.layoutManager = GridLayoutManager(context, 2)
        adapter = FavoritesAdapter { movieId: String -> searchMovie(movieId) }
        binding.rw.adapter = adapter

        binding.bmenu.selectedItemId = R.id.item2
        binding.bmenu.setOnNavigationItemSelectedListener {
            when (it.itemId){

                R.id.item1 ->{findNavController().navigate(R.id.action_favouritesFragment_to_searchFragment)}

            }
            true
        }

        displayStartPreview()

        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayStartPreview(){

        viewModel.getAllFavoritesPreview.observe(viewLifecycleOwner

        ) {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        }

    }

    private fun searchMovie(movieId: String) {
        searchViewModel.searchMovie(movieId, Constance.TOKEN)
        searchViewModel.searchReview(movieId)
        findNavController().navigate(R.id.action_favouritesFragment_to_movieFragment)
    }

}