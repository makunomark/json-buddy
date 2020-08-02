package me.gachoka.buddy.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import me.gachoka.buddy.data.local.dao.PostDao
import me.gachoka.buddy.data.local.entity.PostEntity

@Database(
    entities = [PostEntity::class],
    version = 1
)
abstract class BuddyDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}
