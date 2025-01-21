package com.jer.newsappcompose.di

import android.app.Application
import androidx.room.Room
import com.jer.newsappcompose.data.local.NewsDao
import com.jer.newsappcompose.data.local.NewsDatabase
import com.jer.newsappcompose.data.local.NewsTypeConverter
import com.jer.newsappcompose.data.manager.LocalUserManagerImpl
import com.jer.newsappcompose.data.remote.NewsApi
import com.jer.newsappcompose.data.repository.NewsRepositoryImpl
import com.jer.newsappcompose.domain.manager.LocalUserManager
import com.jer.newsappcompose.domain.repository.NewsRepository
import com.jer.newsappcompose.domain.usecase.appentry.AppEntryUsecases
import com.jer.newsappcompose.domain.usecase.appentry.ReadAppEntry
import com.jer.newsappcompose.domain.usecase.appentry.SaveAppEntry
import com.jer.newsappcompose.domain.usecase.news.DeleteArticle
import com.jer.newsappcompose.domain.usecase.news.GetNews
import com.jer.newsappcompose.domain.usecase.news.NewsUseCase
import com.jer.newsappcompose.domain.usecase.news.SearchNews
import com.jer.newsappcompose.domain.usecase.news.SelectArticle
import com.jer.newsappcompose.domain.usecase.news.SelectArticles
import com.jer.newsappcompose.domain.usecase.news.UpsertArticle
import com.jer.newsappcompose.util.Constants.BASE_URL
import com.jer.newsappcompose.util.Constants.NEWS_DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsApi: NewsApi): NewsRepository {
        return NewsRepositoryImpl(newsApi)

    }

    @Provides
    @Singleton
    fun provideNewsUseCases(newsRepository: NewsRepository, newsDao: NewsDao) : NewsUseCase {
        return NewsUseCase(
            GetNews(newsRepository),
            SearchNews(newsRepository),
            UpsertArticle(newsDao),
            DeleteArticle(newsDao),
            SelectArticles(newsDao),
            SelectArticle(newsDao)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(application: Application): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DB_NAME
        )
            .addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(newsDatabase: NewsDatabase) = newsDatabase.newsDao

}