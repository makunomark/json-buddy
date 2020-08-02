package me.gachoka.buddy.data.local.dao

import androidx.room.Dao
import me.gachoka.buddy.data.local.entity.PostEntity

@Dao
interface PostDao : BaseDao<PostEntity>
