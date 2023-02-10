package com.example.kplist.presentation.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kplist.databinding.MovieItemBinding
import com.example.kplist.domain.modelsUseCase.FavoritesPreviewUseCaseModel
import com.squareup.picasso.Picasso

class FavoritesAdapter(
    private val searchMovie: (movieId: String) -> Unit
) : RecyclerView.Adapter<FavoritesAdapter.FavoritesHolder>() {

    private var cardList = ArrayList<FavoritesPreviewUseCaseModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesHolder {
        val binding: MovieItemBinding = MovieItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return FavoritesHolder(binding)
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun onBindViewHolder(holder: FavoritesHolder, position: Int) {
        holder.bind(cardList[position], searchMovie)
    }

    fun setList(list: List<FavoritesPreviewUseCaseModel>) {
        cardList.clear()
        cardList.addAll(list)
    }

    class FavoritesHolder(
        val binding: MovieItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            card: FavoritesPreviewUseCaseModel,
            searchMovie: (movieId: String) -> Unit
        ) {
            binding.apply {
                val getImage = card.poster
                Picasso.get().load(getImage).into(imageView)
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