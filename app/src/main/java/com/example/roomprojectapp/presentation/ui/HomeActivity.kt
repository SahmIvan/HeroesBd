package com.example.roomprojectapp.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomprojectapp.R
import com.example.roomprojectapp.domain.adapters.SuperheroesAdapter
import com.example.roomprojectapp.domain.models.Superhero
import com.example.roomprojectapp.presentation.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private val mainViewModel : MainViewModel by viewModels()
    private lateinit var recyclerView : RecyclerView
    private lateinit var filteredSuperheroes: List<Superhero>
    private var team : Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        team = intent.getIntExtra("casa", -1)
        observeState()
    }

    private fun observeState(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                mainViewModel.state.collect{
                    Log.i("Superheroes", it.superheroes.toString())
                    filteredSuperheroes = it.superheroes.filter { superhero -> superhero.casa == team }
                    recyclerView = findViewById(R.id.recyclerView)
                    recyclerView.adapter = SuperheroesAdapter(filteredSuperheroes){superhero ->
                        val intent = Intent(this@HomeActivity, SuperheroDetailActivity::class.java).apply {
                            putExtra("superhero", superhero)
                        }
                        startActivity(intent)
                    }
                    val layoutManager = GridLayoutManager(this@HomeActivity, 2)
                    recyclerView.layoutManager = layoutManager
                }
            }
        }
    }
}