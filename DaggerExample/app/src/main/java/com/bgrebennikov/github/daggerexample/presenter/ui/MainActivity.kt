package com.bgrebennikov.github.daggerexample.presenter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bgrebennikov.github.daggerexample.databinding.ActivityMainBinding
import com.bgrebennikov.github.daggerexample.presenter.App
import com.bgrebennikov.github.daggerexample.presenter.adapters.MainAdapter
import com.bgrebennikov.github.daggerexample.presenter.viewModels.MainViewModel
import com.bgrebennikov.github.daggerexample.presenter.viewModels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    private val viewModel by lazy{
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    private val component by lazy { (application as App).component }

    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        viewModel.listPhotos.observe(this, Observer {
            adapter.photosList = it
            binding.recyclerView.adapter = adapter
        })

    }


    companion object{
        private const val TAG = "MESSAGE"
    }

}