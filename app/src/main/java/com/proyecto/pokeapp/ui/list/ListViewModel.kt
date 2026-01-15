package com.proyecto.pokeapp.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proyecto.pokeapp.data.AppRepository
import com.proyecto.pokeapp.data.models.Ability
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val appRepository: AppRepository) : ViewModel() {

    private val _items = MutableStateFlow<List<Ability>>(emptyList())
    val items: StateFlow<List<Ability>> = _items.asStateFlow()

    private var nextUrl: String? = null
    private var isLoading = false

    init {
        loadInitialItems()
    }

    private fun loadInitialItems() {
        viewModelScope.launch {
            if (isLoading) return@launch
            isLoading = true
            try {
                val response = appRepository.getAbilities(10)
                _items.value = response.results
                nextUrl = response.next
            } catch (e: Exception) {
                // Handle error
            } finally {
                isLoading = false
            }
        }
    }

    fun loadMoreItems() {
        if (isLoading || nextUrl == null) {
            return
        }

        viewModelScope.launch {
            isLoading = true
            try {
                val response = appRepository.getAbilitiesByUrl(nextUrl!!)
                _items.update { currentItems ->
                    currentItems + response.results
                }
                nextUrl = response.next
            } catch (e: Exception) {
                // Handle error
            } finally {
                isLoading = false
            }
        }
    }
}