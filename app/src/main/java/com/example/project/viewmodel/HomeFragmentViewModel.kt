package com.example.project.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.project.App
import com.example.project.data.entity.Film
import com.example.project.domain.Interactor
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import java.util.*
import java.util.concurrent.Executors
import javax.inject.Inject

class HomeFragmentViewModel : ViewModel() {
    val showProgressBar: Channel<Boolean>
    //Инициализируем интерактор
    @Inject
    lateinit var interactor: Interactor
    val filmsListData : Flow<List<Film>>
    init {
        App.instance.dagger.inject(this)
        showProgressBar = interactor.progressBarState
        filmsListData = interactor.getFilmsFromDB()
        getFilms()
    }
    fun getFilms() {
    /*    showProgressBar.postValue(true)
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
        }*/
        interactor.getFilmsFromApi(1)
    }

    interface ApiCallback {
        fun onSuccess()
        fun onFailure()
    }
}
