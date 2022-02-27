package com.bgrebennikov.github.diffutillesson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.bgrebennikov.github.diffutillesson.adapters.AdapterMain
import com.bgrebennikov.github.diffutillesson.adapters.SwipeToDeleteCallback
import com.bgrebennikov.github.diffutillesson.databinding.ActivityMainBinding
import com.bgrebennikov.github.diffutillesson.models.TaskModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val adapter = AdapterMain()
    private val todoList = mutableListOf(
        TaskModel(
            "Buy an apple", false
        ),
        TaskModel(
            "Drive to auto service", true
        ),
        TaskModel(
            "Read a book", false
        ),
        TaskModel(
            "Buy an apple", false
        ),
        TaskModel(
            "Drive to auto service", true
        ),
        TaskModel(
            "Read a book", false
        ),
        TaskModel(
            "Buy an apple", false
        ),
        TaskModel(
            "Drive to auto service", true
        ),
        TaskModel(
            "Read a book", false
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        adapter.taskList = todoList

        binding.recyclerView.adapter = adapter

        val swipeHandler = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                todoList.remove(todoList[viewHolder.adapterPosition])
                adapter.taskList = todoList
            }

        }

        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(binding.recyclerView)


    }
}