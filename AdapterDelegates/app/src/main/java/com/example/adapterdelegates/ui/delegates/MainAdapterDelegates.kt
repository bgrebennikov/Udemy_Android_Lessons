package com.example.adapterdelegates.ui.delegates

import com.example.adapterdelegates.databinding.AdsItemBinding
import com.example.adapterdelegates.databinding.PostItemBinding
import com.example.adapterdelegates.ui.adapters.MainAdapter
import com.example.adapterdelegates.ui.adapters.models.data.AdsDataModel
import com.example.adapterdelegates.ui.adapters.models.data.PostsDataModel
import com.example.adapterdelegates.ui.adapters.models.types.ListItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object MainAdapterDelegates {

    val postsDelegate = adapterDelegateViewBinding<PostsDataModel, ListItem, PostItemBinding>(
        { inflater, container ->
            PostItemBinding.inflate(inflater, container, false)
        }
    ) {

        bind {
            binding.title.text = item.title
            binding.body.text = item.body
        }
    }

    val adsDelegate = adapterDelegateViewBinding<AdsDataModel, ListItem, AdsItemBinding>(
        { inflater, container ->
            AdsItemBinding.inflate(inflater, container, false)
        }
    ) {
        bind {
            binding.title.text = item.title
            binding.body.text = item.body
        }
    }

}