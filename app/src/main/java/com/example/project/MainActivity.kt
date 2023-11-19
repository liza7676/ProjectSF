package com.example.project

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnMenu = findViewById<Button>(R.id.button_menu)
        val btnFavorites = findViewById<Button>(R.id.button_favorites)
        val btnLater = findViewById<Button>(R.id.button_later)
        val btnCollections = findViewById<Button>(R.id.button_collections)
        val btnSettings = findViewById<Button>(R.id.button_settings)
        btnMenu.setOnClickListener{
            Toast.makeText(this, "Меню", Toast.LENGTH_SHORT).show()
        }
        btnFavorites.setOnClickListener{
            Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
        }
        btnLater.setOnClickListener{
            Toast.makeText(this, "Посмотреть позже", Toast.LENGTH_SHORT).show()
        }
        btnCollections.setOnClickListener{
            Toast.makeText(this, "Подборка", Toast.LENGTH_SHORT).show()
        }
        btnSettings.setOnClickListener{
            Toast.makeText(this, "Настройка", Toast.LENGTH_SHORT).show()
        }
    }
}