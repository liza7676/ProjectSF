package com.example.project.view.rv_viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project.R
import com.example.project.data.ApiConstants
import com.example.project.domain.Film
import com.example.project.view.customviews.RatingDonutView

//В конструктор класс передается layout, который мы создали(film_item.xml)
class FilmViewHolder( private val itemView: View
) : RecyclerView.ViewHolder(itemView) {

    //Привязываем View из layout к переменным
    private val title = itemView.findViewById<TextView>(R.id.title)
    private val poster = itemView.findViewById<ImageView>(R.id.poster)
    private val description = itemView.findViewById<TextView>(R.id.description)
    //Вот здесь мы находим в верстке наш прогресс бар для рейтинга
    private val ratingDonut = itemView.findViewById<RatingDonutView>(R.id.rating_donut)
    //В этом методе кладем данные из Film в наши View
    fun bind(film: Film) {
        //Устанавливаем заголовок
        title.text = film.title
        //Устанавливаем постер
        Glide.with(itemView)
            .load(ApiConstants.IMAGES_URL + "w780" + film.poster)
            .centerCrop()
            .into(poster)
        //Устанавливаем описание
        description.text = film.description
        //Устанавливаем рэйтинг
        ratingDonut.setProgress((film.rating * 10).toInt())
    }
}