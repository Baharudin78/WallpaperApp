package com.baharudin.wallpaperapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.baharudin.wallpaperapp.R
import com.baharudin.wallpaperapp.data.UnsplashData
import com.baharudin.wallpaperapp.databinding.ItemPictureBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class UnsplashAdapter : PagingDataAdapter<UnsplashData, UnsplashAdapter.UnsplashViewHolder>(PHOTO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnsplashViewHolder {
        val inflater = ItemPictureBinding.inflate(
                LayoutInflater.from(
                        parent.context
                ),parent,
                false)
        return UnsplashViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: UnsplashViewHolder, position: Int) {
        val curentItem = getItem(position)
        if (curentItem != null){
            holder.bind(curentItem)
        }
    }

    class UnsplashViewHolder(val binding : ItemPictureBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(photo : UnsplashData){
            binding.apply {
                Glide.with(itemView)
                        .load(photo.urls)
                        .centerCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .error(R.drawable.ic_error)
                        .into(ivPhoto)

                tvUsername.text = photo.user.username

            }
        }
    }

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<UnsplashData>(){
            override fun areItemsTheSame(oldItem: UnsplashData, newItem: UnsplashData): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: UnsplashData, newItem: UnsplashData): Boolean {
               return oldItem == newItem
            }

        }
    }

}