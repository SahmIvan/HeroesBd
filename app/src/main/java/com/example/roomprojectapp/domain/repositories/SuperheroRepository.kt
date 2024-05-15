package com.example.roomprojectapp.domain.repositories

import kotlinx.coroutines.flow.Flow
import com.example.roomprojectapp.domain.models.Superhero

interface SuperheroRepository {
    suspend fun getSuperheroes(): Flow<List<Superhero>>
}