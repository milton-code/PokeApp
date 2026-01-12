package com.proyecto.pokeapp

import android.app.Application
import com.proyecto.pokeapp.data.AppContainer

class PokeApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
    }
}