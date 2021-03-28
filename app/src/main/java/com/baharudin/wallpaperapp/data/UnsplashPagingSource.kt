package com.baharudin.wallpaperapp.data

import androidx.paging.PagingSource
import com.baharudin.wallpaperapp.api.UnsplashService
import retrofit2.HttpException
import java.io.IOException

private const val UNSPLASH_STARTING_PAGE = 1
class UnsplashPagingSource(

    val unsplashService: UnsplashService,
    val query : String
) : PagingSource<Int, UnsplashData>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashData> {
        val position = params.key ?: UNSPLASH_STARTING_PAGE

        return try {
            val response = unsplashService.getSearchImage(query,position, params.loadSize)
            val photo = response.results

            LoadResult.Page(
                data = photo,
                prevKey = if (position == UNSPLASH_STARTING_PAGE) null else position -1,
                nextKey = if (photo.isEmpty()) null else position +1
            )
        }catch (e : IOException){
            LoadResult.Error(e)
        }catch (ex : HttpException){
            LoadResult.Error(ex)
        }
    }
}