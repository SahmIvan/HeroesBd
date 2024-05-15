package com.example.roomprojectapp.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "superhero")
data class Superhero(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val casa: Int,  // 0 para Marvel, 1 para DC
    val afiliacion: String, // "Heroe" o "Villano"
    val imagen: String
) : Serializable