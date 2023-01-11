package com.example.kplist.presentation.facts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kplist.databinding.FactItemBinding
import com.example.kplist.domain.modelsUseCase.DetailUseCaseModel

class FactAdapter: RecyclerView.Adapter<FactAdapter.FactHolder>() {

    private var factList = ArrayList<DetailUseCaseModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactHolder {

        val binding : FactItemBinding = FactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FactHolder(binding)
    }

    override fun getItemCount(): Int {
        return factList.size
    }

    override fun onBindViewHolder(holder: FactHolder, position: Int) {
        holder.bind(factList[position])
    }

    fun setList (list: List<DetailUseCaseModel>){
        factList.clear()
        factList.addAll(list)
    }

    class FactHolder(val binding: FactItemBinding): RecyclerView.ViewHolder(binding.root){


        fun bind(detail: DetailUseCaseModel) {

            binding.apply {

                textFact.text = detail.value

            }


        }
    }

}