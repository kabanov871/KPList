package com.example.kplist.presentation.reviews

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kplist.R
import com.example.kplist.databinding.FragmentPersonBinding
import com.example.kplist.databinding.FragmentReviewBinding
import com.example.kplist.presentation.MyApp
import com.example.kplist.presentation.ViewModelFactory
import com.example.kplist.presentation.facts.FactAdapter
import com.example.kplist.presentation.search.SearchAdapter
import com.example.kplist.presentation.search.SearchViewModel
import javax.inject.Inject

class ReviewFragment : Fragment() {

    private lateinit var binding: FragmentReviewBinding
    private lateinit var adapter: ReviewAdapter
    private lateinit var viewModel: ReviewViewModel

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
        binding = FragmentReviewBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory)[ReviewViewModel::class.java]
        binding.rv.layoutManager = LinearLayoutManager(context)
        adapter = ReviewAdapter()
        binding.rv.adapter = adapter
        displayStartReview()
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayStartReview() {
        viewModel.getReview.observe(
            viewLifecycleOwner
        ) {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        }
    }
}