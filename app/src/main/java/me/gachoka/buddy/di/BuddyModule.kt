package me.gachoka.buddy.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object BuddyModule {

    @Provides
    fun provideHelloWorld(): String {
        return "Hello world!"
    }
}