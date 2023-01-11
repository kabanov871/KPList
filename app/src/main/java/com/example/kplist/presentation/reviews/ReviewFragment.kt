package com.example.kplist.presentation.reviews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kplist.R
import com.example.kplist.databinding.FragmentPersonBinding
import com.example.kplist.databinding.FragmentReviewBinding

class ReviewFragment : Fragment() {

    lateinit var binding: FragmentReviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReviewBinding.inflate(inflater, container, false)

        return binding.root
    }

}