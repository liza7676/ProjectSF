package com.example.project.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.project.App
import com.example.project.data.entity.Film
import com.example.project.domain.Interactor
import java.util.*
import java.util.concurrent.Executors
import javax.inject.Inject

class HomeFragmentViewModel : ViewModel() {
    val showProgressBar: MutableLiveData<Boolean> = MutableLiveData()
    //Инициализируем интерактор
    @Inject
    lateinit var interactor: Interactor
    val filmsListLiveData : LiveData<List<Film>>
    init {
        App.instance.dagger.inject(this)
        filmsListLiveData = interactor.getFilmsFromDB()
        getFilms()
    }
    fun getFilms() {
        showProgressBar.postValue(true)
        val dataCur = Calendar.getInstance().timeInMillis
        val data = interactor.getDounloadTimeFromPreferences()
        if ((dataCur - data) > 600000){
            interactor.clearCache()
            interactor.getFilmsFromApi(1, object : ApiCallback {
                override fun onSuccess() {
                    showProgressBar.postValue(false)
                }

                override fun onFailure() {
                    Executors.newSingleThreadExecutor().execute {
                        showProgressBar.postValue(false)
                    }
                }
            })
        } else {
            Executors.newSingleThreadExecutor().execute {
                showProgressBar.postValue(false)
            }
        }
    }

    interface ApiCallback {
        fun onSuccess()
        fun onFailure()
    }
}
