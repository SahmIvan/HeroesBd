package com.example.roomprojectapp.presentation.states

import com.example.roomprojectapp.domain.models.Superhero

data class SuperheroState(
    val superheroes: List<Superhero> = emptyList()
)