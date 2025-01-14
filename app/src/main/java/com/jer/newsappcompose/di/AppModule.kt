package com.jer.newsappcompose.di

import android.app.Application
import com.jer.newsappcompose.data.manager.LocalUserManagerImpl
import com.jer.newsappcompose.domain.manager.LocalUserManager
import com.jer.newsappcompose.domain.usecase.AppEntryUsecases
import com.jer.newsappcompose.domain.usecase.ReadAppEntry
import com.jer.newsappcompose.domain.usecase.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager =
        LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(localUserManager: LocalUserManager) =
        AppEntryUsecases(
            saveAppEntry = SaveAppEntry(localUserManager),
            readAppEntry = ReadAppEntry(localUserManager)
        )

}