package com.proyecto.pokeapp.data.models

import kotlinx.serialization.Serializable

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


