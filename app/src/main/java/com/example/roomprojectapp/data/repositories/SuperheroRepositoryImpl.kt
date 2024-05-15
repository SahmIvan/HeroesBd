package com.example.roomprojectapp.data.repositories

import kotlinx.coroutines.flow.Flow
import com.example.roomprojectapp.data.dao.SuperheroDao
import com.example.roomprojectapp.domain.repositories.SuperheroRepository
import com.example.roomprojectapp.domain.models.Superhero
import javax.inject.Inject

class SuperheroRepositoryImpl @Inject constructor(
    private val superheroDao: SuperheroDao
) : SuperheroRepository {
    override suspend fun getSuperheroes(): Flow<List<Superhero>> {
        return superheroDao.getSuperheroes()
    }
}