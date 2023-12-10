package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.Toolbar

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val film1 = intent.extras?.get("film")
        val details_toolbar = findViewById<Toolbar>(R.id.details_toolbar)
        val details_poster = findViewById<AppCompatImageView>(R.id.details_poster)
        val details_description = findViewById<TextView>(R.id.details_description)
        val film = film1 as Film
        //Устанавливаем заголовок
        details_toolbar.title = film.title
        //Устанавливаем картинку
        details_poster.setImageResource(film.poster)
        //Устанавливаем описание
        details_description.text = film.description
    }
}