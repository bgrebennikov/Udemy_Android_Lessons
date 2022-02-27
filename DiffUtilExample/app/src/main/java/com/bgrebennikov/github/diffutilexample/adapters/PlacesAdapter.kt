package com.bgrebennikov.github.diffutilexample.adapters

import com.bgrebennikov.github.diffutilexample.adapters.base.BaseDiffUtilCallback
import com.bgrebennikov.github.diffutilexample.adapters.delegates.MainDelegates
import com.bgrebennikov.github.diffutilexample.models.base.ListItem
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class PlacesAdapter: AsyncListDifferDelegationAdapter<ListItem>(BaseDiffUtilCallback()) {

    init {
        delegatesManager
            .addDelegate(MainDelegates.placeItemSmall())
            .addDelegate(MainDelegates.placeItemLarge())
    }

}