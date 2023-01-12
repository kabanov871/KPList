package com.example.kplist.presentation.persons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kplist.databinding.PersonItemBinding
import com.example.kplist.domain.modelsUseCase.PersonUseCaseModel
import com.squareup.picasso.Picasso

class PersonAdapter(
    private val searchPreviewByPerson: (personId: String) -> Unit
): RecyclerView.Adapter<PersonAdapter.PersonHolder>() {

    private var personList = ArrayList<PersonUseCaseModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {

        val binding : PersonItemBinding = PersonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonHolder(binding)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        holder.bind(personList[position], searchPreviewByPerson)
    }

    fun setList (list: List<PersonUseCaseModel>){
        personList.clear()
        personList.addAll(list)
    }

    class PersonHolder(val binding: PersonItemBinding): RecyclerView.ViewHolder(binding.root){


        fun bind(person: PersonUseCaseModel,
                 searchPreviewByPerson:(personId: String)->Unit) {

            binding.apply {

                val getImage = person.photo
                Picasso.get().load(getImage).into(imageViewPerson)
                textViewProf.text = person.prof
                textViewPersonName.text = person.name
                cardView.setOnClickListener{
                    searchPreviewByPerson(person.personId.toString())
                }

            }


        }
    }

}