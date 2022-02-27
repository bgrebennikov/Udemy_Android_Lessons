package com.example.diexample.ui.main

import androidx.recyclerview.widget.DiffUtil
import com.example.diexample.models.base.ListItem
import com.example.diexample.ui.base.BaseDiffUtilItemCallback
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class MainScreenAdapter() : AsyncListDifferDelegationAdapter<ListItem>(BaseDiffUtilItemCallback()) {

    init {
        delegatesManager.addDelegate(MainScreenDelegates.gamesHorizontalDelegate())
    }

}