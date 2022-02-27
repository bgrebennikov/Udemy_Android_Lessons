package com.edricaazaza.coroutineslearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.edricaazaza.coroutineslearning.databinding.ActivityMainBinding
import com.edricaazaza.coroutineslearning.viewModels.MainViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.downloadBtn.setOnClickListener {
            lifecycleScope.launch {
                loadData()
            }
        }
    }

    private suspend fun loadData() {
        binding.progressCircular.visibility = View.VISIBLE

        val city = getCity()

        binding.city = city
        binding.temperature = getTemperature(city)

        binding.progressCircular.visibility = View.GONE

    }


    private suspend fun getCity(): String {
        delay(3000L)
        return "Samara"
    }

    private suspend fun getTemperature(city: String): Int {
        Toast.makeText(this, "Loading temperature for city: $city", Toast.LENGTH_SHORT).show()
        delay(3000L)
        return 12
    }


}