package com.example.project.di.modules

import android.content.Context
import androidx.room.Room
import com.example.project.AppDatabase
import com.example.project.data.DAO.FilmDao
import com.example.project.data.DatabaseHelper
import com.example.project.data.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabaseHelper(context: Context) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "film_db"
    ).build().filmDao()


    @Provides
    @Singleton
    fun provideRepository(filmDao: FilmDao) = MainRepository(filmDao)
}