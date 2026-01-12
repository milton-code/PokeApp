package com.proyecto.pokeapp.data.network

import com.proyecto.pokeapp.data.models.AbilityDetailResponse
import com.proyecto.pokeapp.data.models.AbilityResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface PokeApiService {

    @GET("ability")
    suspend fun getAbilities(
        @Query("limit") limit: Int
    ): AbilityResponse

    @GET
    suspend fun getAbilitiesByUrl(@Url url: String): AbilityResponse

    @GET
    suspend fun getAbilityDetails(@Url url: String): AbilityDetailResponse
}