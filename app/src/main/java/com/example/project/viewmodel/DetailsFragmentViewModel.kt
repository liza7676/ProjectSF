package com.example.project.viewmodel

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.ViewModel
import java.io.IOException
import kotlin.coroutines.suspendCoroutine
import kotlin.coroutines.resume
import java.net.URL

class DetailsFragmentViewModel  : ViewModel() {
    suspend fun loadWallpaper(url: String): Bitmap? {
        return suspendCoroutine {
            try {
                val url = URL(url)
                val bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())
                it.resume(bitmap)
            } catch (e: IOException){
                it.resume(null)
            }
        }
    }
}