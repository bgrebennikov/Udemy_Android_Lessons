package com.example.diexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diexample.R
import com.example.diexample.databinding.ActivityMainBinding
import com.example.diexample.ui.main.MainFragment

class MainActivity : AppCompatActivity() {


    val TAG = "message"

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.container, MainFragment())
                .commitAllowingStateLoss()
        }

    }






}