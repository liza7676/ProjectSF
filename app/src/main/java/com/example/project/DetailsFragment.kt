package com.example.project

import android.content.Intent
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val film1 = arguments?.get("film") as Film
        val details_toolbar = view.findViewById<Toolbar>(R.id.details_toolbar)
        val details_poster = view.findViewById<AppCompatImageView>(R.id.details_poster)
        val details_description = view.findViewById<TextView>(R.id.details_description)
        val film = film1
        //Устанавливаем заголовок
        details_toolbar.title = film.title
        //Устанавливаем картинку
        details_poster.setImageResource(film.poster)
        //Устанавливаем описание
        details_description.text = film.description

        val details_fab_favorites = view.findViewById<FloatingActionButton>(R.id.details_fab_favorites)
        details_fab_favorites.setImageResource(
            if (film.isInFavorites) R.drawable.ic_baseline_favorite_24
            else R.drawable.ic_baseline_favorite_border_24
        )
        details_fab_favorites.setOnClickListener {
            if (!film.isInFavorites) {
                details_fab_favorites.setImageResource(R.drawable.ic_baseline_favorite_24)
                film.isInFavorites = true
            } else {
                details_fab_favorites.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                film.isInFavorites = false
            }
        }
        val details_fab_share = view.findViewById<FloatingActionButton>(R.id.details_fab_share)
        details_fab_share.setOnClickListener {
            //Создаем интент
            val intent = Intent()
            //Указываем action с которым он запускается
            intent.action = Intent.ACTION_SEND
            //Кладем данные о нашем фильме
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "Check out this film: ${film.title} \n\n ${film.description}"
            )
            //Указываем MIME тип, чтобы система знала, какое приложения предложить
            intent.type = "text/plain"
            //Запускаем наше активити
            startActivity(Intent.createChooser(intent, "Share To:"))
        }
    }
}