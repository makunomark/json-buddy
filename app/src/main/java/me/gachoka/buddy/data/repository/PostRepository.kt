package me.gachoka.buddy.data.repository

import me.gachoka.buddy.data.local.dao.PostDao
import me.gachoka.buddy.data.remote.api.BuddyApi
import javax.inject.Inject

interface PostRepository {
    fun getRemotePosts()
    fun getLocalPosts()
    fun savePosts()
}

class PostRepositoryImpl
@Inject constructor(
    private val buddyApi: BuddyApi,
    private val postDao: PostDao
) : PostRepository {

    override fun getRemotePosts() {

    }

    override fun getLocalPosts() {

    }

    override fun savePosts() {

    }
}
