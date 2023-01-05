package com.example.kplist.presentation.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kplist.R
import com.example.kplist.databinding.FragmentFavouritesBinding

class FavouritesFragment : Fragment() {

    lateinit var binding: FragmentFavouritesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavouritesBinding.inflate(inflater, container, false)

        binding.bmenu.selectedItemId = R.id.item2
        binding.bmenu.setOnNavigationItemSelectedListener {
            when (it.itemId){

                R.id.item1 ->{findNavController().navigate(R.id.action_favouritesFragment_to_searchFragment)}

            }
            true
        }

        return binding.root
    }

}