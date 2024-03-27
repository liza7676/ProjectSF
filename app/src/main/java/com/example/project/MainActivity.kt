package com.example.project

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.project.databinding.ActivityMainBinding
import com.example.project.domain.Film
import com.example.project.view.fragments.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var backPress = 0L
    var fileFavList = listOf<Film>()
    var pageView = 1

    //Ищем фрагмент по тегу, если он есть то возвращаем его, если нет, то null
    private fun checkFragmentExistence(tag: String): Fragment? =
        supportFragmentManager.findFragmentByTag(tag)

    private fun changeFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment, tag)
            //.addToBackStack(null)
            .commit()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            Log.d("YAYAYA", "${it.itemId}")
            when (it.itemId) {
                R.id.favorites -> {
                    val tag = "favorites"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment(fragment ?: FavoritesFragment(), tag)
                    true
                }
                R.id.watch_later -> {
                    val tag = "watch_later"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment(fragment ?: LaterFragment(), tag)
                    true
                }
                R.id.selections -> {
                    val tag = "selections"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment(fragment ?: CollectionFragment(), tag)
                    true
                }
                R.id.home -> {
                    val tag = "home"
                    val fragment = checkFragmentExistence(tag)
                    //В первом параметре, если фрагмент не найден и метод вернул null, то с помощью
                    changeFragment(fragment ?: HomeFragment(), tag)
                    true
                }
                R.id.settings -> {
                    val tag = "settings"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment( fragment?: SettingsFragment(), tag)
                    true
                }
                else -> false
            }
        }
        //Запускаем фрагмент при старте
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_placeholder, StartActiviti())
            //.addToBackStack(null)
            .commit()

    }

    fun startApp(){
        val fragment = HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment)
           // .addToBackStack(null)
            .commit()
    }

    fun launchDetailsFragment(film: Film) {
        //Создаем "посылку"
        val bundle = Bundle()
        //Кладем наш фильм в "посылку"
        bundle.putParcelable("film", film)
        //Кладем фрагмент с деталями в перменную
        val fragment = DetailsFragment()
        //Прикрепляем нашу "посылку" к фрагменту
        fragment.arguments = bundle

        //Запускаем фрагмент
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment)
            .addToBackStack(null)
            .commit()
    }

    //    override fun onBackPressed() { //выход по двойной стрелке назад из программы
//        if (supportFragmentManager.backStackEntryCount == 1){
//            if (backPress + TIME_INTERVAL > System.currentTimeMillis()){
//                super.onBackPressed()
//                finish()
//            } else{
//                Toast.makeText(this, "double tap for exit", Toast.LENGTH_SHORT).show()
//            }
//            backPress = System.currentTimeMillis()
//        } else {
//            super.onBackPressed()
//        }
//    }
    companion object{
        const val TIME_INTERVAL = 2000
    }
}