package com.baharudin.wallpaperapp.api

import com.baharudin.wallpaperapp.data.UnsplashResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashService {

    companion object{
        const val BASE_URL ="https://api.unsplash.com/"
        const val CLIENT_ID = "H23GmCQyX59Rt1GzT5O6Z6eUvBUftfwDPMipU2y4kXY"

    }
    @Headers("Accept-Version: v1","Authorization: Client_ID: $CLIENT_ID")
    @GET("search/photos")
    suspend fun getSearchImage(
        @Query("query") query : String,
        @Query("page") page : Int,
        @Query("per_page") perPage : Int
    ) : UnsplashResponse
}