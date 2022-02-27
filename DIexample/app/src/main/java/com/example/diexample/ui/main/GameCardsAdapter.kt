package com.example.diexample.ui.main

import com.example.diexample.models.base.ListItem
import com.example.diexample.ui.base.BaseDiffUtilItemCallback
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class GameCardsAdapter : AsyncListDifferDelegationAdapter<ListItem>(BaseDiffUtilItemCallback()) {

    init {
        delegatesManager
            .addDelegate(MainScreenDelegates.thinGameDelegate())
            .addDelegate(MainScreenDelegates.wideGameDelegate())

            .addDelegate(MainScreenDelegates.wideProgressDelegate())
            .addDelegate(MainScreenDelegates.thinProgressDelegate())
    }


}