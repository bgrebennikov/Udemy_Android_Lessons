package com.example.diexample.ui.main

import android.app.Activity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions
import com.example.diexample.R
import com.example.diexample.databinding.*
import com.example.diexample.models.base.ListItem
import com.example.diexample.models.game.*
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object MainScreenDelegates {


    fun gamesHorizontalDelegate() =
        adapterDelegateViewBinding<GamesHorizontalItem, ListItem, ItemGamesHorizontalBinding>(
            { inflater, container ->
                ItemGamesHorizontalBinding.inflate(inflater, container, false)
            }
        ) {

            val adapter = GameCardsAdapter()
            binding.recyclerView.adapter = adapter

            bind {
                binding.titleTextView.text = item.title
                adapter.items = item.games
            }


        }

    fun wideProgressDelegate() =
        adapterDelegateViewBinding<ProgressWideItem, ListItem, ItemProgressWideBinding>(
            { inflater, container ->
                ItemProgressWideBinding.inflate(inflater, container, false)
            }
        ) {}

    fun thinProgressDelegate() =
        adapterDelegateViewBinding<ProgressThinItem, ListItem, ItemProgressThinBinding>(
            { inflater, container ->
                ItemProgressThinBinding.inflate(inflater, container, false)
            }
        ) {}


    fun wideGameDelegate() =
        adapterDelegateViewBinding<GameWideItem, ListItem, ItemGameWideBinding>(
            { inflater, container ->
                ItemGameWideBinding.inflate(inflater, container, false)
            }
        ) {
            bind {
                val resources = binding.root.resources
                try {
                    Glide.with(binding.root)
                        .load(item.image)
                        .transform(
                            CenterCrop(),
                            RoundedCorners(resources.getDimensionPixelOffset(R.dimen.game_card_corners_radius))
                        )
                        .transition(withCrossFade())
                        .override(
                            resources.getDimensionPixelOffset(R.dimen.game_card_wide_width),
                            resources.getDimensionPixelOffset(R.dimen.game_card_wide_height)
                        )
                        .into(binding.imageView)
                } catch (e: Exception) {
                    // err
                }


                binding.title = item.title
                binding.executePendingBindings()
            }

            onViewRecycled {
                if ((binding.root.context as? Activity)?.isDestroyed?.not() == true) {
                    Glide.with(binding.root)
                        .clear(binding.imageView)
                }
            }


        }

    fun thinGameDelegate () =
        adapterDelegateViewBinding<GameThinItem, ListItem, ItemGameThinBinding>(
            { inflater, container ->
                ItemGameThinBinding.inflate(inflater, container, false)
            }
        ) {
            bind {

                val resources = binding.root.resources
                try {
                    Glide.with(binding.root)
                        .load(item.image)
                        .transform(
                            CenterCrop(),
                            RoundedCorners(resources.getDimensionPixelOffset(R.dimen.game_card_corners_radius))
                        )
                        .transition(withCrossFade())
                        .override(
                            resources.getDimensionPixelOffset(R.dimen.game_card_thin_width),
                            resources.getDimensionPixelOffset(R.dimen.game_card_thin_height)
                        )
                        .into(binding.imageView)
                } catch (e: Exception) {
                    // err
                }

                binding.title = item.title
                binding.executePendingBindings()
            }

            onViewRecycled {
                if ((binding.root.context as? Activity)?.isDestroyed?.not() == true) {
                    Glide.with(binding.root)
                        .clear(binding.imageView)
                }
            }

        }


}