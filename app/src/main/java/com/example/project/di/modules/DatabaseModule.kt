package com.example.project.di.modules

import android.content.Context
import com.example.project.data.DatabaseHelper
import com.example.project.data.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabaseHelper(context: Context) = DatabaseHelper(context)

    @Provides
    @Singleton
    fun provideRepository(databaseHelper: DatabaseHelper) =
        MainRepository(databaseHelper)
}