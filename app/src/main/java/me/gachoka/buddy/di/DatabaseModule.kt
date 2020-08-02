package me.gachoka.buddy.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import me.gachoka.buddy.data.local.BuddyDatabase
import me.gachoka.buddy.data.local.dao.PostDao
import me.gachoka.buddy.util.Constants
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext applicationContext: Context): BuddyDatabase {
        return Room.databaseBuilder(
            applicationContext,
            BuddyDatabase::class.java,
            Constants.DB_NAME
        ).build()
    }

    @Provides
    fun providePostDao(database: BuddyDatabase): PostDao {
        return database.postDao()
    }
}
