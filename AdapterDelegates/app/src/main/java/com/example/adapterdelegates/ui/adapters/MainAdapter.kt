package com.example.adapterdelegates.ui.adapters

import com.example.adapterdelegates.ui.adapters.models.types.ListItem
import com.example.adapterdelegates.ui.base.BaseDiffUtilItemCallback
import com.example.adapterdelegates.ui.delegates.MainAdapterDelegates
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class MainAdapter() : AsyncListDifferDelegationAdapter<ListItem>(BaseDiffUtilItemCallback()) {

    init {
        delegatesManager
            .addDelegate(MainAdapterDelegates.postsDelegate)
            .addDelegate(MainAdapterDelegates.adsDelegate)
    }

}