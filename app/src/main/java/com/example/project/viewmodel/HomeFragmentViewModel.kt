package com.example.project.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.project.App
import com.example.project.data.entity.Film
import com.example.project.domain.Interactor
import io.reactivex.rxjava3.subjects.BehaviorSubject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import java.util.*
import java.util.concurrent.Executors
import javax.inject.Inject
import io.reactivex.rxjava3.core.Observable

class HomeFragmentViewModel : ViewModel() {

    //Инициализируем интерактор
    @Inject
    lateinit var interactor: Interactor
    val filmsListData : Observable<List<Film>>
    val showProgressBar: BehaviorSubject<Boolean>

    init {
        App.instance.dagger.inject(this)
        showProgressBar = interactor.progressBarState
        filmsListData = interactor.getFilmsFromDB()
        getFilms()
    }
    fun getFilms() {
        interactor.getFilmsFromApi(1)
    }

    interface ApiCallback {
        fun onSuccess()
        fun onFailure()
    }
}
