package com.example.kplist.presentation.movies

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.kplist.R
import com.example.kplist.data.models.apiMovieModel.Person
import com.example.kplist.databinding.FragmentMovieBinding
import com.example.kplist.databinding.FragmentSearchBinding
import com.example.kplist.domain.modelsUseCase.DetailUseCaseModel
import com.example.kplist.presentation.Constance
import com.example.kplist.presentation.MyApp
import com.example.kplist.presentation.ViewModelFactory
import com.example.kplist.presentation.search.SearchViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.*
import javax.inject.Inject


class MovieFragment : Fragment() {

    lateinit var binding: FragmentMovieBinding
    private lateinit var viewModel: MovieViewModel

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
        binding = FragmentMovieBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, viewModelFactory)[MovieViewModel::class.java]

         viewModel.getMovie().observe(viewLifecycleOwner) {
            val response = it

                if (response != null) {
                    binding.textViewRatingKp.text = response.ratingKp.toString()
                    binding.textViewRatingImdb.text = response.ratingImdb.toString()
                    binding.textViewRatingCritics.text = response.ratingCritic.toString()
                    binding.textMovieName.text = response.name
                    val getImage = response.poster
                    Picasso.get().load(getImage).into(binding.imageViewPoster)
                    binding.textYear.text = response.year
                    binding.textDesc.text = response.description
                }
         }

            viewModel.getDetail(R.string.detail_country.toString()).observe(viewLifecycleOwner) {
                if (it.isEmpty()) {
                    binding.textView17.setVisibility(View.INVISIBLE)
                }
                if (it.size == 1) {
                    binding.country1.text = it[0].value
                }
                if (it.size == 2) {
                    binding.country1.text = it[0].value
                    binding.country2.text = it[1].value
                }
                if (it.size == 3) {
                    binding.country1.text = it[0].value
                    binding.country2.text = it[1].value
                    binding.country3.text = it[2].value
                }
                if (it.size > 3) {
                    binding.country1.text = it[0].value
                    binding.country2.text = it[1].value
                    binding.country3.text = it[2].value
                    binding.country4.text = it[3].value
                }
            }

        binding.buttonPerson.setOnClickListener {
            findNavController().navigate(R.id.action_movieFragment_to_personFragment)
        }
        binding.buttonFact.setOnClickListener {
            findNavController().navigate(R.id.action_movieFragment_to_factsFragment)
        }
        binding.buttonTrailer.setOnClickListener {
            findNavController().navigate(R.id.action_movieFragment_to_trailerFragment)
        }
        binding.buttonReview.setOnClickListener {
            findNavController().navigate(R.id.action_movieFragment_to_reviewFragment)
        }


        return binding.root
    }

}