package com.bgrebennikov.github.diffexample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bgrebennikov.github.diffexample.databinding.RvItemBinding
import com.bgrebennikov.github.diffexample.models.PersonModel

class AdapterMain : RecyclerView.Adapter<AdapterMain.ViewHolder>() {

    var namesList = listOf<PersonModel>()
        set(value){
            val callback = NamesDiffCallback(namesList, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    inner class ViewHolder(private val binding: RvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(person: PersonModel) {
            with(binding){
                name = person.name
                age = person.age
                isEmployer = person.isEmployer
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterMain.ViewHolder {
        val view = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterMain.ViewHolder, position: Int) {
        holder.bind(namesList[position])
    }

    override fun getItemCount(): Int = namesList.size
}