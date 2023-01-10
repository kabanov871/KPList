package com.example.kplist.presentation.search

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kplist.R
import com.example.kplist.databinding.FragmentSearchBinding
import com.example.kplist.presentation.Constance
import com.example.kplist.presentation.MyApp
import com.example.kplist.presentation.ViewModelFactory
import javax.inject.Inject


class SearchFragment : Fragment() {

    lateinit var binding: FragmentSearchBinding
    lateinit var adapter: SearchAdapter
    private lateinit var viewModel: SearchViewModel

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

        binding.bmenu.selectedItemId = R.id.item1
        binding.bmenu.setOnNavigationItemSelectedListener {
            when (it.itemId){

                R.id.item2 ->{findNavController().navigate(R.id.action_searchFragment_to_favouritesFragment)}

            }
            true
        }

        binding.rw.layoutManager = GridLayoutManager(context, 2)
        adapter = SearchAdapter ({ movieId: String -> searchMovie(movieId)},{openMovie()})
        binding.rw.adapter = adapter

        binding.button.setOnClickListener {
            searchByNamePreview(binding.editText.text.toString())
        }

        binding.button2.setOnClickListener {
            val panelCategory = BottomSheetFragment { nameField: String,
                                                      search: String,
                                                      nameField2: String,
                                                      search2: String,
                                                      sortField: String,
                                                      sortType: String ->
                advancedSearch(
                    nameField, search, nameField2, search2, sortField, sortType
                )
            }
            val parameters = Bundle()
            parameters.putString("idCategory", "wordEntity.hint")
            panelCategory.arguments = parameters

            panelCategory.show((context as FragmentActivity).supportFragmentManager, "editCategory")
        }

        displayStartPreview()

        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayStartPreview(){

        viewModel.getAllPreview.observe(viewLifecycleOwner

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
    ){
        viewModel.advancedSearchPreview(
            nameField, search, nameField2, search2, sortField, sortType, Constance.LIMIT, Constance.TOKEN
        )
    }
    private fun searchMovie(movieId: String) {
        viewModel.searchMovie(movieId, Constance.TOKEN)
    }
    private fun openMovie() {
        findNavController().navigate(R.id.action_searchFragment_to_movieFragment)
    }

}