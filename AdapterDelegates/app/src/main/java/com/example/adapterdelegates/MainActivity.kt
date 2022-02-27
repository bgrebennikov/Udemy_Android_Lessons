package com.example.adapterdelegates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adapterdelegates.databinding.ActivityMainBinding
import com.example.adapterdelegates.databinding.FragmentMainBinding
import com.example.adapterdelegates.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentLayoutMain, MainFragment())
                .commitAllowingStateLoss()
        }

    }
}