package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar

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

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navigation = findViewById<CoordinatorLayout>(R.id.details_id)

        bottom_navigation.setOnNavigationItemSelectedListener {
            Log.d("YAYAYA", "${it.itemId}")
            when (it.itemId) {
                R.id.favorites -> {
                    val snackbar = Snackbar.make(navigation, "В избранное", Snackbar.LENGTH_SHORT)
                    snackbar.setAction("Push!!!", ){
                        Toast.makeText(this, "Посмотреть позже ", Toast.LENGTH_SHORT).show()
                    }
                    snackbar.setActionTextColor(ContextCompat.getColor(this, R.color.yello))
                    snackbar.show()
                    true
                }
                R.id.watch_later -> {
                    val snackbar = Snackbar.make(navigation, "Посмотреть позже ", Snackbar.LENGTH_SHORT)
                    snackbar.setAction("Push!!!", ){
                        Toast.makeText(this, "Посмотреть позже ", Toast.LENGTH_SHORT).show()
                    }
                    snackbar.setActionTextColor(ContextCompat.getColor(this, R.color.yello))
                    snackbar.show()
                    true
                }
                R.id.selections -> {
                    Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

}