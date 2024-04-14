package com.example.project

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.project.data.DAO.FilmDao
import com.example.project.data.entity.Film

@Database(entities = [Film::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}