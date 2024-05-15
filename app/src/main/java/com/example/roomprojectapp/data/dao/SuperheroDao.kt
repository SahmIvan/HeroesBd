package com.example.roomprojectapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomprojectapp.domain.models.Superhero
import kotlinx.coroutines.flow.Flow

@Dao
interface SuperheroDao {
    @Query("SELECT * FROM superhero")
    fun getSuperheroes(): Flow<List<Superhero>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSuperheroes(superheroes: List<Superhero>)
}