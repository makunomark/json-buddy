package me.gachoka.buddy.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE

interface BaseDao<T> {

    @Insert(onConflict = REPLACE)
    suspend fun insert(vararg t: T)
}
