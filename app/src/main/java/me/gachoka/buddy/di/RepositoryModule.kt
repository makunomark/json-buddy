package me.gachoka.buddy.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import me.gachoka.buddy.data.local.dao.PostDao
import me.gachoka.buddy.data.remote.api.BuddyApi
import me.gachoka.buddy.data.repository.PostRepository
import me.gachoka.buddy.data.repository.PostRepositoryImpl

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Provides
    fun providePostRepository(buddyApi: BuddyApi, postDao: PostDao): PostRepository {
        return PostRepositoryImpl(buddyApi, postDao)
    }
}
