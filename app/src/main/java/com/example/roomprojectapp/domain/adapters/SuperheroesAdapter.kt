package com.example.roomprojectapp.domain.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomprojectapp.R
import com.squareup.picasso.Picasso
import com.example.roomprojectapp.domain.models.Superhero

class SuperheroesAdapter(
    private val superheroes: List<Superhero>,
    val onClick: (Superhero) -> Unit
) : RecyclerView.Adapter<SuperheroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.superhero_item, parent, false)
        return SuperheroViewHolder(view)
    }

    override fun getItemCount(): Int {
        return superheroes.size
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        val superhero = superheroes[position]
        holder.nameTextView.text = superhero.name
        holder.affiliationTextView.text = superhero.afiliacion
        Picasso.get().load(superhero.imagen).resize(600, 200)
            .centerInside().into(holder.imageView)
        holder.itemView.setOnClickListener {
            onClick(superhero)
        }
    }
}

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val nameTextView: TextView
    val affiliationTextView: TextView
    val imageView: ImageView

    init {
        nameTextView = view.findViewById(R.id.tvSuperheroName)
        affiliationTextView = view.findViewById(R.id.tvSuperheroAffiliation)
        imageView = view.findViewById(R.id.imgSuperhero)
    }
}