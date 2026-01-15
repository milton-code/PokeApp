package com.proyecto.pokeapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proyecto.pokeapp.data.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val appRepository: AppRepository) : ViewModel() {

    private val _flavorText = MutableStateFlow<String?>(null)
    val flavorText: StateFlow<String?> = _flavorText.asStateFlow()

    fun loadDetails(url: String) {
        viewModelScope.launch {
            try {
                val response = appRepository.getAbilityDetails(url)
                val spanishFlavorText = response.flavorTextEntries
                    .firstOrNull { it.language.name == "es" }?.flavorText
                _flavorText.value = spanishFlavorText
            } catch (e: Exception) {
                _flavorText.value = "Error al cargar la descripción."
            }
        }
    }
}