package com.proyecto.pokeapp.data.models

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonIgnoreUnknownKeys

@Serializable
data class AbilityResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Ability>
)

@Serializable
data class Ability(
    val name: String,
    val url: String
)


