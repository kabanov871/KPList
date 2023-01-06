package com.example.kplist.presentation.search

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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kplist.R
import com.example.kplist.databinding.FragmentSearchBinding
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

        initRecycler()
        displayCards()

        return binding.root
    }

    private fun initRecycler(){
        binding.rw.layoutManager = GridLayoutManager(context, 2)
        adapter = SearchAdapter()
        binding.rw.adapter = adapter

    }


    @SuppressLint("NotifyDataSetChanged")
    private fun displayCards(){

        viewModel.getStartList().observe(viewLifecycleOwner

        ) {
            adapter.setList(it.asReversed())
            adapter.notifyDataSetChanged()
        }

    }

}