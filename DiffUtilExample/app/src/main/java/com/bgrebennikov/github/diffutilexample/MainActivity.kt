package com.bgrebennikov.github.diffutilexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bgrebennikov.github.diffutilexample.adapters.MainAdapter
import com.bgrebennikov.github.diffutilexample.databinding.ActivityMainBinding
import com.bgrebennikov.github.diffutilexample.models.PlacesHorizontalModel
import com.bgrebennikov.github.diffutilexample.models.PlacesModelLarge
import com.bgrebennikov.github.diffutilexample.models.PlacesModelSmall

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = adapter

        adapter.items = listOf(
            PlacesHorizontalModel(
                "Russia",
                listOf(
                    PlacesModelSmall(
                        "Samara"
                    ),
                    PlacesModelSmall(
                        "N. Novgorod"
                    ),
                    PlacesModelSmall(
                        "Vladivostok"
                    ),
                    PlacesModelSmall(
                        "St. Peterburg"
                    ),
                    PlacesModelSmall(
                        "Moskow"
                    )
                ),
            ),
            PlacesHorizontalModel(
                "Russia",
                listOf(
                    PlacesModelLarge(
                        "Samara"
                    ),
                    PlacesModelLarge(
                        "N. Novgorod"
                    ),
                    PlacesModelLarge(
                        "Vladivostok"
                    ),
                    PlacesModelLarge(
                        "St. Peterburg"
                    ),
                    PlacesModelLarge(
                        "Moskow"
                    )
                ),
            ),
            PlacesHorizontalModel(
                "Russia",
                listOf(
                    PlacesModelSmall(
                        "Samara"
                    ),
                    PlacesModelSmall(
                        "N. Novgorod"
                    ),
                    PlacesModelSmall(
                        "Vladivostok"
                    ),
                    PlacesModelSmall(
                        "St. Peterburg"
                    ),
                    PlacesModelSmall(
                        "Moskow"
                    )
                ),
            ),
        )

    }
}