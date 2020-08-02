package me.gachoka.buddy.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import me.gachoka.buddy.data.local.entity.PostEntity

@Dao
interface PostDao : BaseDao<PostEntity> {

    @Query("SELECT * FROM postentity")
    suspend fun getAllPosts(): List<PostEntity>
}
