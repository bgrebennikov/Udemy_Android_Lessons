package com.bgrebennikov.github.daggerexample.presenter.adapters

import androidx.recyclerview.widget.RecyclerView
import com.bgrebennikov.github.daggerexample.data.models.PhotosModel
import com.bgrebennikov.github.daggerexample.databinding.ListItemBinding
import com.bumptech.glide.Glide

class MainViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: PhotosModel){
        with(binding){
            itemTitle = data.title
            imageUrl = data.thumbnailUrl
        }
    }

}