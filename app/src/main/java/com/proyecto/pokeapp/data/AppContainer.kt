package com.proyecto.pokeapp.data

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.proyecto.pokeapp.data.network.PokeApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

class AppContainer(context: Context) {
    private val baseUrl = "https://pokeapi.co/api/v2/"
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: PokeApiService by lazy { retrofit.create(PokeApiService::class.java) }

    val appRepository: AppRepository by lazy {
        AppRepository( retrofitService )
    }
}