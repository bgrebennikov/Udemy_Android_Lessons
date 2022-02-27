package com.example.adapterdelegates.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.adapterdelegates.R
import com.example.adapterdelegates.databinding.FragmentMainBinding
import com.example.adapterdelegates.ui.adapters.MainAdapter
import com.example.adapterdelegates.ui.adapters.models.data.AdsDataModel
import com.example.adapterdelegates.ui.adapters.models.data.PostsDataModel
import com.example.adapterdelegates.ui.delegates.viewBinding
import com.example.adapterdelegates.viewmodels.main.MainViewModel

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding { FragmentMainBinding.bind(it) }
    private val adapter = MainAdapter()

    private val viewModel by viewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.postsData.observe(viewLifecycleOwner, Observer {
            binding.recyclerMain.adapter = adapter
            adapter.items = it
        })



    }


}