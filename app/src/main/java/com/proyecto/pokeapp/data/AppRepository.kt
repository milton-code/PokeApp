package com.proyecto.pokeapp.data

import com.proyecto.pokeapp.data.models.AbilityDetailResponse
import com.proyecto.pokeapp.data.models.AbilityResponse
import com.proyecto.pokeapp.data.network.PokeApiService
import javax.inject.Inject

interface AppRepository {
    suspend fun getAbilities(limit: Int): AbilityResponse
    suspend fun getAbilitiesByUrl(url: String): AbilityResponse
    suspend fun getAbilityDetails(url: String): AbilityDetailResponse
}

class NetworkAppRepository @Inject constructor(private val pokeApiService: PokeApiService) : AppRepository {

    override suspend fun getAbilities(limit: Int): AbilityResponse = pokeApiService.getAbilities(limit)

    override suspend fun getAbilitiesByUrl(url: String): AbilityResponse = pokeApiService.getAbilitiesByUrl(url)

    override suspend fun getAbilityDetails(url: String): AbilityDetailResponse = pokeApiService.getAbilityDetails(url)
}