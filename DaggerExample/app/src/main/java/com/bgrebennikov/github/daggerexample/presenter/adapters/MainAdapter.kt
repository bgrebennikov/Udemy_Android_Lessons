package com.bgrebennikov.github.daggerexample.presenter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bgrebennikov.github.daggerexample.data.models.PhotosModel
import com.bgrebennikov.github.daggerexample.databinding.ListItemBinding

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var photosList: List<PhotosModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(photosList[position])
    }

    override fun getItemCount() = photosList.size
}