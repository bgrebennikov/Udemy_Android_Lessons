package com.bgrebennikov.github.diffutilexample.adapters.delegates

import com.bgrebennikov.github.diffutilexample.adapters.PlacesAdapter
import com.bgrebennikov.github.diffutilexample.databinding.ItemLargeBinding
import com.bgrebennikov.github.diffutilexample.databinding.ItemSmallBinding
import com.bgrebennikov.github.diffutilexample.databinding.LayoutListHorizontalBinding
import com.bgrebennikov.github.diffutilexample.models.PlacesHorizontalModel
import com.bgrebennikov.github.diffutilexample.models.PlacesModelLarge
import com.bgrebennikov.github.diffutilexample.models.PlacesModelSmall
import com.bgrebennikov.github.diffutilexample.models.base.ListItem
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object MainDelegates {

    fun placesHorizontalDelegate(): AdapterDelegate<List<ListItem>> {
        return adapterDelegateViewBinding<PlacesHorizontalModel, ListItem, LayoutListHorizontalBinding>(
            { inflater, container ->
                LayoutListHorizontalBinding.inflate(inflater, container, false)
            }
        ) {
            val adapter = PlacesAdapter()

            binding.listItemHorizontal.adapter = adapter

            bind {
                binding.title.text = item.title
                adapter.items = item.places
            }

        }
    }

    fun placeItemSmall() : AdapterDelegate<List<ListItem>> {
        return adapterDelegateViewBinding<PlacesModelSmall, ListItem, ItemSmallBinding>(
            { inflater, container ->
                ItemSmallBinding.inflate(inflater, container, false)
            }
        ){
            bind {
                binding.title.text = item.title
            }
        }
    }

    fun placeItemLarge() : AdapterDelegate<List<ListItem>>{
        return adapterDelegateViewBinding<PlacesModelLarge, ListItem, ItemLargeBinding>(
            { inflater, container ->
                ItemLargeBinding.inflate(inflater, container, false)
            }
        ){
            bind {
                binding.title.text = item.title
            }
        }
    }





}