package com.example.kplist.presentation.trailers

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kplist.R
import com.example.kplist.databinding.FragmentTrailerBinding
import com.example.kplist.presentation.MyApp
import com.example.kplist.presentation.ViewModelFactory
import com.example.kplist.presentation.facts.FactViewModel
import javax.inject.Inject

class TrailerFragment : Fragment() {

    private lateinit var binding: FragmentTrailerBinding
    private lateinit var adapter: TrailerAdapter
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
        binding = FragmentTrailerBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory)[FactViewModel::class.java]
        binding.rv.layoutManager = LinearLayoutManager(context)
        adapter = TrailerAdapter { url: String -> openUrl(url) }
        binding.rv.adapter = adapter
        displayStartTrailer()
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayStartTrailer() {
        viewModel.getDetail(R.string.detail_trailer.toString())
            .observe(viewLifecycleOwner) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}