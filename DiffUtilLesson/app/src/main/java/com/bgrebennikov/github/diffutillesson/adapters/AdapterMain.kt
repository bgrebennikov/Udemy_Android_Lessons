package com.bgrebennikov.github.diffutillesson.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bgrebennikov.github.diffutillesson.databinding.ListItemBinding
import com.bgrebennikov.github.diffutillesson.models.TaskModel

class AdapterMain : RecyclerView.Adapter<AdapterMain.ViewHolder>() {

    var taskList = listOf<TaskModel>()
        set(value) {
            val callback = ListItemDiffCallback(taskList, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    inner class ViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: TaskModel) {
            binding.name = task.name
            binding.isDone = task.isDone
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterMain.ViewHolder {
        val view = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterMain.ViewHolder, position: Int) {
        holder.bind(taskList[position])
    }

    override fun getItemCount(): Int = taskList.size

}