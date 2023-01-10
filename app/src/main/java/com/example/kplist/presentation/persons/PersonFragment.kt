package com.example.kplist.presentation.persons

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kplist.R
import com.example.kplist.databinding.FragmentFactsBinding
import com.example.kplist.databinding.FragmentPersonBinding

class PersonFragment : Fragment() {

    lateinit var binding: FragmentPersonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPersonBinding.inflate(inflater, container, false)

        return binding.root
    }

}