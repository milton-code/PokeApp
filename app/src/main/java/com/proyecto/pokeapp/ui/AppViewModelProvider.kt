package com.proyecto.pokeapp.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.proyecto.pokeapp.PokeApplication
import com.proyecto.pokeapp.ui.detail.DetailViewModel
import com.proyecto.pokeapp.ui.list.ListViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            ListViewModel(pokeApplication().container.appRepository)
        }

        initializer {
            DetailViewModel(pokeApplication().container.appRepository)
        }
    }
}

fun CreationExtras.pokeApplication(): PokeApplication = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PokeApplication)