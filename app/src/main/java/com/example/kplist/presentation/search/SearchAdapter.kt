package com.example.kplist.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kplist.R
import com.example.kplist.databinding.MovieItemBinding
import com.example.kplist.domain.modelsUseCase.PreviewUseCaseModel
import com.squareup.picasso.Picasso

class SearchAdapter (private val searchMovie: (movieId: String) -> Unit
) : RecyclerView.Adapter<SearchAdapter.SearchHolder>(){

    private var cardList = ArrayList<PreviewUseCaseModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHolder {

        val binding : MovieItemBinding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchHolder(binding)
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        holder.bind(cardList[position], searchMovie)
    }

    fun setList (list: List<PreviewUseCaseModel>){
        cardList.clear()
        cardList.addAll(list)
    }

    class SearchHolder(val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root){


        fun bind(card: PreviewUseCaseModel,
                 searchMovie:(movieId: String)->Unit) {

            binding.apply {

                if (card.poster == null) {
                    val getImage = R.drawable.no_poster
                    Picasso.get().load(getImage).into(imageView)
                } else {
                    val getImage = card.poster
                    Picasso.get().load(getImage).into(imageView)
                }

                textViewKp.text = card.ratingKp.toString()
                textViewImdb.text = card.ratingImdb.toString()
                textViewName.text = card.name
                textViewYear.text = card.year
                cardView.setOnClickListener {
                    searchMovie(card.id.toString())
                }

            }


        }
    }

}