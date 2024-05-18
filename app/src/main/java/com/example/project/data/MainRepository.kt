package com.example.project.data

import android.content.ContentValues
import android.database.Cursor
import androidx.lifecycle.LiveData
import com.example.project.data.DAO.FilmDao
import com.example.project.data.entity.Film
import com.example.project.utils.AutoDisposable
import com.example.project.utils.addTo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors
import kotlinx.coroutines.flow.first as first1
import kotlinx.coroutines.flow.toList as toList

class MainRepository(private val filmDao: FilmDao) {
    private val autoDisposable = AutoDisposable()
    fun putToDb(films: List<Film>) {
        //Запросы в БД должны быть в отдельном потоке
            filmDao.insertAll(films)
    }

    fun getAllFromDB(): Observable<List<Film>> = filmDao.getCachedFilms()

    //Очистка кэша
    fun clearCache(){

        val cachedFilms = filmDao.getCachedFilms()
        cachedFilms.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { list ->
                    filmDao.deleteDB(list)
                }
                .addTo(autoDisposable)
    }
    //Очистить кэш от фильмов с рейтингом ниже 8.0
    fun clearInCacheBadFilms(){
        val cachedFilms = filmDao.getCachedFilmsGood(0.0, 7.99)
        cachedFilms.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { list ->
                list.forEach {
                    filmDao.deleteFilm(it)
                }
            }
            .addTo(autoDisposable)
    }
}