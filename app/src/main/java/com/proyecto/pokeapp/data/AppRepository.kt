package com.proyecto.pokeapp.data

import com.proyecto.pokeapp.data.models.AbilityDetailResponse
import com.proyecto.pokeapp.data.models.AbilityResponse
import com.proyecto.pokeapp.data.network.PokeApiService

class AppRepository (private val pokeApiService: PokeApiService){

    suspend fun getAbilities(limit: Int): AbilityResponse = pokeApiService.getAbilities(limit)

    suspend fun getAbilitiesByUrl(url: String): AbilityResponse = pokeApiService.getAbilitiesByUrl(url)

    suspend fun getAbilityDetails(url: String): AbilityDetailResponse = pokeApiService.getAbilityDetails(url)
}