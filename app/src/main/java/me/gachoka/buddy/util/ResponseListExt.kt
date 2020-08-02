package me.gachoka.buddy.util

import me.gachoka.buddy.data.local.entity.PostEntity
import me.gachoka.buddy.data.remote.model.PostsResponse

/**
 * An extension function to help convert a list of post response to a list of posts that we
 * can save to room database
 */
fun List<PostsResponse>.toListOfEntity(): List<PostEntity> {
    val entityList = mutableListOf<PostEntity>()

    for (response in this) {
        entityList.add(response.convertToEntity())
    }

    return entityList
}