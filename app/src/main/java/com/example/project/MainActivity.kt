package com.example.project

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.AnticipateOvershootInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val topAppBar = findViewById<MaterialToolbar>(R.id.topAppBar)
        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val poster2 = findViewById<CardView>(R.id.poster_2)
        val poster3 = findViewById<CardView>(R.id.poster_3)
        val poster4 = findViewById<CardView>(R.id.poster_4)

        topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        bottom_navigation.setOnNavigationItemSelectedListener {
            Log.d("YAYAYA", "${it.itemId}")
            when (it.itemId) {
                R.id.favorites -> {
                    Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.watch_later -> {
                    Toast.makeText(this, "Посмотреть похже", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.selections -> {
                    Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        poster2.setOnClickListener {
            val myAnimation5 = AnimationUtils.loadAnimation(this, R.anim.rotate_scale)
            poster2.startAnimation(myAnimation5)
        }

        val animatorPosr = AnimatorSet()
        val animatorPosr1 = AnimatorSet()
        poster3.setOnClickListener {
            val poster3Anim = ObjectAnimator.ofFloat(poster3, View.TRANSLATION_Y, -150f)
            poster3Anim.interpolator = AnticipateOvershootInterpolator()
            poster3Anim.duration = 1500

            val poster3Anim1 = ObjectAnimator.ofFloat(poster3, View.TRANSLATION_X, -125f)
            poster3Anim1.interpolator = AnticipateOvershootInterpolator()
            poster3Anim1.duration = 1500

            val poster3Anim2 = ObjectAnimator.ofFloat(poster3, View.ALPHA, 1f)
            poster3Anim2.duration = 1500
            poster3Anim2.interpolator = AnticipateOvershootInterpolator()

            val poster3Anim3 = ObjectAnimator.ofFloat(poster3, View.SCALE_X, 2f)
            poster3Anim3.duration = 1500

            animatorPosr.playTogether(poster3Anim1, poster3Anim)
            animatorPosr.playTogether(poster3Anim2, poster3Anim3)
            animatorPosr.start()
            animatorPosr.reverse()
        }

        poster4.setOnClickListener {
            val poster3Anim = ObjectAnimator.ofFloat(poster4, View.SCALE_Y, 0.2f)
            poster3Anim.duration = 1000

            val poster3Anim1 = ObjectAnimator.ofFloat(poster4, View.ALPHA, 0f)
            poster3Anim1.duration = 1000

            val poster3Anim2 = ObjectAnimator.ofFloat(poster4, View.SCALE_Y, 1f)
            poster3Anim2.duration = 1500

            val poster3Anim3 = ObjectAnimator.ofFloat(poster4, View.ALPHA, 1f)
            poster3Anim3.duration = 1500

            animatorPosr1.play(poster3Anim)
            animatorPosr1.play(poster3Anim2).after(poster3Anim)
            animatorPosr1.start()
        }
    }
}