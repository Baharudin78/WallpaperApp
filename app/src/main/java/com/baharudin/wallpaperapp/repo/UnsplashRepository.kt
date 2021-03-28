package com.baharudin.wallpaperapp.repo

import androidx.hilt.lifecycle.ViewModelInject
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.baharudin.wallpaperapp.api.UnsplashService
import com.baharudin.wallpaperapp.data.UnsplashPagingSource
import javax.inject.Singleton

@Singleton
class UnsplashRepository @ViewModelInject constructor(
    private val unsplashService: UnsplashService
    ) {

    fun getSearchImage(query : String) =
        Pager(
            config = PagingConfig(
                pageSize = 10,
                maxSize = 200,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {UnsplashPagingSource(unsplashService, query)}
        ).liveData
}