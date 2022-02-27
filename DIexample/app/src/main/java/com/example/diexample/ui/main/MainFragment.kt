package com.example.diexample.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.diexample.R
import com.example.diexample.databinding.FragmentMainBinding
import com.example.diexample.ui.base.viewBinding
import com.example.diexample.viewModels.main.MainScreenViewModel
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import androidx.lifecycle.Observer
import com.example.diexample.DI
import com.example.diexample.viewModels.main.DaggerMainScreenComponent
import com.example.diexample.viewModels.main.MainScreenComponent

class MainFragment : Fragment(R.layout.fragment_main) {

    private val component by lazy { MainScreenComponent.create() }

    private val binding by viewBinding { FragmentMainBinding.bind(it) }
    private val viewModel by viewModels<MainScreenViewModel> {component.viewModelFactory()}
    private val adapter = MainScreenAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            recyclerView.adapter = adapter

            viewModel.data.observe(viewLifecycleOwner, Observer { data ->
                adapter.items = data
            })

        }

    }



}