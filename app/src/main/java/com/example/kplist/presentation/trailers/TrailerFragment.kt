package com.example.kplist.presentation.trailers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kplist.R
import com.example.kplist.databinding.FragmentReviewBinding
import com.example.kplist.databinding.FragmentTrailerBinding

class TrailerFragment : Fragment() {

    lateinit var binding: FragmentTrailerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrailerBinding.inflate(inflater, container, false)

        return binding.root
    }

}