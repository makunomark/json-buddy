package me.gachoka.buddy.data.repository

import android.util.Log
import me.gachoka.buddy.data.local.dao.PostDao
import me.gachoka.buddy.data.local.entity.PostEntity
import me.gachoka.buddy.data.remote.api.BuddyApi
import me.gachoka.buddy.data.remote.model.PostsResponse
import me.gachoka.buddy.util.toListOfEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

interface PostRepository {
    fun getRemotePosts()
    fun getLocalPosts()
    fun savePosts(vararg posts: PostEntity)
}

class PostRepositoryImpl
@Inject constructor(
    private val buddyApi: BuddyApi,
    private val postDao: PostDao
) : PostRepository {

    override fun getRemotePosts() {
        buddyApi.getPosts().enqueue(object : Callback<List<PostsResponse>> {
            override fun onFailure(call: Call<List<PostsResponse>>, t: Throwable) {
                t.printStackTrace()
                Log.e(javaClass.simpleName, t.localizedMessage)
            }

            override fun onResponse(
                call: Call<List<PostsResponse>>,
                response: Response<List<PostsResponse>>
            ) {
                response.body()?.toListOfEntity()?.toTypedArray()?.let {
                    if (it.isNotEmpty()) savePosts(*it)
                }
            }
        })
    }

    override fun getLocalPosts() {

    }

    override fun savePosts(vararg posts: PostEntity) {
        postDao.insert(*posts)
    }
}
