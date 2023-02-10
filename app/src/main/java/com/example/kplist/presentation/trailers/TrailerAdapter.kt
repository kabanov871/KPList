package com.example.kplist.presentation.trailers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kplist.databinding.FactItemBinding
import com.example.kplist.databinding.TrailerItemBinding
import com.example.kplist.domain.modelsUseCase.DetailUseCaseModel
import com.example.kplist.presentation.facts.FactAdapter

class TrailerAdapter(
    private val openUrl: (url: String) -> Unit
) : RecyclerView.Adapter<TrailerAdapter.TrailerHolder>() {

    private var trailerList = ArrayList<DetailUseCaseModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrailerHolder {
        val binding: TrailerItemBinding = TrailerItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TrailerHolder(binding)
    }

    override fun getItemCount(): Int {
        return trailerList.size
    }

    override fun onBindViewHolder(holder: TrailerHolder, position: Int) {
        holder.bind(trailerList[position], openUrl)
    }

    fun setList(list: List<DetailUseCaseModel>) {
        trailerList.clear()
        trailerList.addAll(list)
    }

    class TrailerHolder(val binding: TrailerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(trailer: DetailUseCaseModel, openUrl: (url: String) -> Unit) {
            binding.cardView.setOnClickListener { trailer.value?.let { it1 -> openUrl(it1) } }
        }
    }
}