package me.gachoka.buddy.data.remote.api

import me.gachoka.buddy.data.remote.model.PostsResponse
import retrofit2.Call
import retrofit2.http.GET

interface BuddyApi {

    @GET("/posts")
    fun getPosts(): Call<List<PostsResponse>>
}
