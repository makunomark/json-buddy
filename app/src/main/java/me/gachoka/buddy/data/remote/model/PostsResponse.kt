package me.gachoka.buddy.data.remote.model

import me.gachoka.buddy.data.local.entity.PostEntity

data class PostsResponse(
    val userId: Int,
    val id: Int,
    val body: String,
    val title: String
) {

    fun convertToEntity(): PostEntity {
        return PostEntity(
            id, userId, title, body
        )
    }
}
