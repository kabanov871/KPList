package com.example.kplist.presentation.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kplist.R
import com.example.kplist.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        binding.bmenu.selectedItemId = R.id.item1
        binding.bmenu.setOnNavigationItemSelectedListener {
            when (it.itemId){

                R.id.item2 ->{findNavController().navigate(R.id.action_searchFragment_to_favouritesFragment)}

            }
            true
        }

        return binding.root
    }

}