package com.baharudin.wallpaperapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.baharudin.wallpaperapp.repo.UnsplashRepository

class GaleryViewModel @ViewModelInject constructor(
    private val unsplashRepository: UnsplashRepository
) : ViewModel() {

    val currentQuery = MutableLiveData(DEFAULT_QUERY)

    val photo = currentQuery.switchMap { queryString ->
        unsplashRepository.getSearchImage(queryString).cachedIn(viewModelScope)
    }

    fun searchImageQuery(query : String){
        currentQuery.value = query
    }

    companion object {
        const val DEFAULT_QUERY = "cats"
    }
}