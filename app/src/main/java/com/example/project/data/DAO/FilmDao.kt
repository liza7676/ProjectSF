package com.example.project.data.DAO

import androidx.room.*
import com.example.project.data.entity.Film
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmDao {
    //Запрос на всю таблицу
    @Query("SELECT * FROM cached_films")
    fun getCachedFilms(): Observable<List<Film>>

    //Кладём списком в БД, в случае конфликта перезаписываем
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Film>)

    @Delete
    fun deleteDB(list: List<Film>)

    @Delete
    fun deleteFilm(film: Film)

    @Query("SELECT * FROM cached_films WHERE vote_average BETWEEN :minAge  AND :maxAge")
    fun getCachedFilmsGood(minAge: Double, maxAge: Double): Observable<List<Film>>
}