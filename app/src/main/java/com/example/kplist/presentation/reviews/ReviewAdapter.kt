package com.example.kplist.presentation.reviews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kplist.databinding.ReviewItemBinding
import com.example.kplist.domain.modelsUseCase.ReviewUseCaseModel

class ReviewAdapter : RecyclerView.Adapter<ReviewAdapter.ReviewHolder>() {

    private var reviewList = ArrayList<ReviewUseCaseModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewHolder {
        val binding: ReviewItemBinding = ReviewItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ReviewHolder(binding)
    }

    override fun getItemCount(): Int {
        return reviewList.size
    }

    override fun onBindViewHolder(holder: ReviewHolder, position: Int) {
        holder.bind(reviewList[position])
    }

    fun setList(list: List<ReviewUseCaseModel>) {
        reviewList.clear()
        reviewList.addAll(list)
    }

    class ReviewHolder(val binding: ReviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(review: ReviewUseCaseModel) {
            binding.apply {
                textAuthor.text = review.author
                textViewType.text = review.type
                textTitle.text = review.title
                textReview.text = review.review
                textLike.text = review.likes.toString()
                textDislike.text = review.dislikes.toString()
            }
        }
    }
}