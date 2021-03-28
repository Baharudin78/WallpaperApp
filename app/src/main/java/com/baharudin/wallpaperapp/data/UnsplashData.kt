package com.baharudin.wallpaperapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UnsplashData (
    val id : String,
    val description : String,
    val user : UserUnsplash,
    val urls : UrlsUnsplash
        ) : Parcelable {

    @Parcelize
    data class UserUnsplash(
     val name : String,
     val username : String
    ) : Parcelable {
        val attributeUrl get() = "https://unsplash.com/$username?utm_source=WallpaperApp&utm_medium=referral"
    }
    @Parcelize
    data class UrlsUnsplash(
        val raw : String,
        val full : String,
        val regular : String,
        val small : String,
        val thumb : String,
    ) : Parcelable
}