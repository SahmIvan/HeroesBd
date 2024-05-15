package com.example.roomprojectapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.roomprojectapp.R
import com.squareup.picasso.Picasso
import com.example.roomprojectapp.domain.models.Superhero

class SuperheroDetailActivity : AppCompatActivity() {
    private lateinit var superheroName: TextView
    private lateinit var superheroAffiliation: TextView
    private lateinit var superheroImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero_detail)

        superheroName = findViewById(R.id.tvSuperheroName)
        superheroAffiliation = findViewById(R.id.tvSuperheroAffiliation)
        superheroImage = findViewById(R.id.imgSuperhero)

        val superhero = intent.getSerializableExtra("superhero") as Superhero

        superheroName.text = superhero.name
        superheroAffiliation.text = superhero.afiliacion
        Picasso.get().load(superhero.imagen).resize(600, 200)
            .centerInside().into(superheroImage)
    }
}