package com.example.roomprojectapp.domain.use_cases

import kotlinx.coroutines.flow.Flow
import com.example.roomprojectapp.domain.repositories.SuperheroRepository
import com.example.roomprojectapp.domain.models.Superhero

class GetSuperheroes(
    private val repository: SuperheroRepository
) {
    suspend operator fun invoke(): Flow<List<Superhero>> {
        return repository.getSuperheroes()
    }
}