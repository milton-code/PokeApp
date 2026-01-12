package com.proyecto.pokeapp.data.models

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonIgnoreUnknownKeys

@OptIn(ExperimentalSerializationApi::class)
@JsonIgnoreUnknownKeys
@Serializable
data class AbilityDetailResponse(
    @SerialName("flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntry>
)
@OptIn(ExperimentalSerializationApi::class)
@JsonIgnoreUnknownKeys
@Serializable
data class FlavorTextEntry(
    @SerialName("flavor_text")
    val flavorText: String,
    val language: LanguageInfo
)

@Serializable
data class LanguageInfo(
    val name: String,
    val url: String
)
