package com.example.kplist.presentation.facts

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
import com.example.kplist.databinding.FragmentFactsBinding
import com.example.kplist.presentation.MyApp
import com.example.kplist.presentation.ViewModelFactory
import javax.inject.Inject

class FactsFragment : Fragment() {

    private lateinit var binding: FragmentFactsBinding
    private lateinit var adapter: FactAdapter
    private lateinit var viewModel: FactViewModel

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
        binding = FragmentFactsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory)[FactViewModel::class.java]
        binding.rv.layoutManager = LinearLayoutManager(context)
        adapter = FactAdapter()
        binding.rv.adapter = adapter
        displayStartFacts()
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayStartFacts() {
        viewModel.getDetail(R.string.detail_fact.toString())
            .observe(viewLifecycleOwner) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }
    }
}