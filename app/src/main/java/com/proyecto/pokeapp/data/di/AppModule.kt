package com.proyecto.pokeapp.data.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.proyecto.pokeapp.data.AppRepository
import com.proyecto.pokeapp.data.NetworkAppRepository
import com.proyecto.pokeapp.data.network.PokeApiService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindAppRepository(networkAppRepository: NetworkAppRepository): AppRepository

    companion object {
        @Provides
        @Singleton
        fun provideRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
                .build()
        }

        @Provides
        @Singleton
        fun providePokeApiService(retrofit: Retrofit): PokeApiService {
            return retrofit.create(PokeApiService::class.java)
        }
    }
}