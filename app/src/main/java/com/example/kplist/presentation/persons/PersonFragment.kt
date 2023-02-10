package com.example.kplist.presentation.persons

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
import com.example.kplist.databinding.FragmentFactsBinding
import com.example.kplist.databinding.FragmentPersonBinding
import com.example.kplist.presentation.MyApp
import com.example.kplist.presentation.ViewModelFactory
import com.example.kplist.presentation.facts.FactAdapter
import com.example.kplist.presentation.facts.FactViewModel
import com.example.kplist.presentation.searchByPerson.SearchByPersonViewModel
import javax.inject.Inject

class PersonFragment : Fragment() {

    private lateinit var binding: FragmentPersonBinding
    private lateinit var adapter: PersonAdapter
    private lateinit var viewModel: PersonViewModel
    private lateinit var viewModelByPerson: SearchByPersonViewModel

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
        binding = FragmentPersonBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(
            this, viewModelFactory
        )[PersonViewModel::class.java]
        viewModelByPerson = ViewModelProvider(
            this, viewModelFactory
        )[SearchByPersonViewModel::class.java]
        binding.rv.layoutManager = GridLayoutManager(context, 2)
        adapter = PersonAdapter { personId: String -> searchPreviewByPerson(personId) }
        binding.rv.adapter = adapter
        displayStartPerson()
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayStartPerson() {
        viewModel.getPerson.observe(
            viewLifecycleOwner
        ) {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        }
    }

    private fun searchPreviewByPerson(personId: String) {
        viewModelByPerson.searchPreviewByPerson(personId)
        findNavController().navigate(R.id.action_personFragment_to_searchByPersonFragment)
    }
}