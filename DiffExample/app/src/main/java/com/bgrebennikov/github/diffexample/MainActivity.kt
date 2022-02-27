package com.bgrebennikov.github.diffexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bgrebennikov.github.diffexample.adapters.AdapterMain
import com.bgrebennikov.github.diffexample.databinding.ActivityMainBinding
import com.bgrebennikov.github.diffexample.models.PersonModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter = AdapterMain()

    private val namesList = mutableListOf(
        PersonModel(
            "aasfaf",
            25,
            true
        ),
        PersonModel(
            "sgsdrg",
            20,
            false
        ),
        PersonModel(
            "aasdrshhe4faf",
            26,
            true
        ),
        PersonModel(
            "ehrdh",
            24,
            true
        ),
        PersonModel(
            "sdhsd",
            55,
            false
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        adapter.namesList = namesList
        binding.recycler.adapter = adapter

        binding.sortAge.setOnClickListener {
            adapter.namesList = namesList.sortedBy { it.age }
        }

        binding.sortEmp.setOnClickListener {
            adapter.namesList = namesList.sortedBy { it.isEmployer }
        }


    }
}