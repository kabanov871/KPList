package com.example.kplist.presentation.searchByPerson

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kplist.databinding.SearchByPersonItemBinding
import com.example.kplist.domain.modelsUseCase.PreviewByPersonUseCaseModel
import com.squareup.picasso.Picasso

class SearchByPersonAdapter(
    private val searchMovie: (movieId: String) -> Unit
) : RecyclerView.Adapter<SearchByPersonAdapter.SearchByPersonHolder>() {

    private var previewByPersonList = ArrayList<PreviewByPersonUseCaseModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchByPersonHolder {
        val binding: SearchByPersonItemBinding = SearchByPersonItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return SearchByPersonHolder(binding)
    }

    override fun getItemCount(): Int {
        return previewByPersonList.size
    }

    override fun onBindViewHolder(holder: SearchByPersonHolder, position: Int) {
        holder.bind(previewByPersonList[position], searchMovie)
    }

    fun setList(list: List<PreviewByPersonUseCaseModel>) {
        previewByPersonList.clear()
        previewByPersonList.addAll(list)
    }

    class SearchByPersonHolder(
        val binding: SearchByPersonItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            model: PreviewByPersonUseCaseModel,
            searchMovie: (movieId: String) -> Unit
        ) {
            binding.apply {
                val getImage = model.movieId
                Picasso.get().load(
                    "https://st.kp.yandex.net/images/film_big/${getImage}.jpg"
                ).into(imageView4)
                textName.text = model.name
                textDescription.text = model.description
                cardView.setOnClickListener {
                    searchMovie(model.movieId.toString())
                }
            }
        }
    }
}