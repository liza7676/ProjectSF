package com.example.project.di.modules

import com.example.project.data.MainRepository
import com.example.project.data.TmdbApi
import com.example.project.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi) = Interactor(repo = repository, retrofitService = tmdbApi)
}