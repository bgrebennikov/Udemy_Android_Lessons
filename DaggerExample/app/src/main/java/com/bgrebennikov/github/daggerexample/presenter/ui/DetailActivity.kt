package com.bgrebennikov.github.daggerexample.presenter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bgrebennikov.github.daggerexample.R
import com.bgrebennikov.github.daggerexample.databinding.ActivityDetailBinding
import com.bgrebennikov.github.daggerexample.presenter.App

class DetailActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }

    private val component by lazy { (application as App).component }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}