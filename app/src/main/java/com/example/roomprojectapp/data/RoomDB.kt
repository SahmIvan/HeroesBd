package com.example.roomprojectapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomprojectapp.data.dao.SuperheroDao
import com.example.roomprojectapp.domain.models.Superhero

@Database(entities = [Superhero::class], version = 1)
abstract class RoomDB : RoomDatabase() {
    abstract fun superheroDao(): SuperheroDao
}