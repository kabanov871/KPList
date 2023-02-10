package com.example.kplist.presentation.search

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kplist.R
import com.example.kplist.databinding.FragmentSearchBinding
import com.example.kplist.presentation.Constance
import com.example.kplist.presentation.MyApp
import com.example.kplist.presentation.ViewModelFactory
import com.example.kplist.presentation.favorites.FavoritesViewModel
import javax.inject.Inject


class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: SearchAdapter
    private lateinit var viewModel: SearchViewModel
    private lateinit var favoritesViewModel: FavoritesViewModel

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
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory)[SearchViewModel::class.java]
        favoritesViewModel = ViewModelProvider(
            this, viewModelFactory
        )[FavoritesViewModel::class.java]
        binding.bmenu.selectedItemId = R.id.item1
        binding.bmenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item2 -> {
                    findNavController()
                        .navigate(R.id.action_searchFragment_to_favouritesFragment)
                }
            }
            return@setOnItemSelectedListener true
        }
        binding.rw.layoutManager = GridLayoutManager(context, 2)
        adapter = SearchAdapter { movieId: String -> searchMovie(movieId) }
        binding.rw.adapter = adapter
        binding.button.setOnClickListener {
            searchByNamePreview(binding.editText.text.toString())
        }
        binding.button2.setOnClickListener {
            val fragment = BottomSheetFragment {
                    nameField: String,
                    search: String,
                    nameField2: String,
                    search2: String,
                    sortField: String,
                    sortType: String -> advancedSearch(
                    nameField, search, nameField2, search2, sortField, sortType
                )
            }
            fragment.show(
                (context as FragmentActivity)
                    .supportFragmentManager, "advancedSearch"
            )
        }
        displayStartPreview()
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayStartPreview() {
        viewModel.getAllPreview.observe(
            viewLifecycleOwner
        ) {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        }
    }

    private fun searchByNamePreview(name: String) {
        viewModel.searchByNamePreview(
            Constance.SORT_BY_NAME,
            name,
            false,
            Constance.SORT_BY_YEAR,
            Constance.FROM_LARGER_TO_SMALLER,
            Constance.LIMIT,
            Constance.TOKEN
        )
    }

    private fun advancedSearch(
        nameField: String,
        search: String,
        nameField2: String,
        search2: String,
        sortField: String,
        sortType: String
    ) {
        viewModel.advancedSearchPreview(
            nameField,
            search,
            nameField2,
            search2,
            sortField,
            sortType,
            Constance.LIMIT,
            Constance.TOKEN
        )
    }

    private fun searchMovie(movieId: String) {
        viewModel.searchMovie(movieId, Constance.TOKEN)
        viewModel.searchReview(movieId)
        findNavController().navigate(R.id.action_searchFragment_to_movieFragment)
    }
}