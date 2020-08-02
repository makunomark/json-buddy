package me.gachoka.buddy.data.remote.api

import retrofit2.http.GET

interface BuddyApi {

    @GET("/posts")
    fun getPosts()
}
