package com.example.roomprojectapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomprojectapp.domain.use_cases.GetSuperheroes
import com.example.roomprojectapp.presentation.states.SuperheroState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getSuperheroes: GetSuperheroes
) : ViewModel() {
    private val _state = MutableStateFlow(SuperheroState())
    val state = _state.asStateFlow()

    init {
        loadSuperheroes()
    }

    private fun loadSuperheroes() {
        viewModelScope.launch {
            try {
                getSuperheroes().collect {
                    _state.value = SuperheroState(superheroes = it)
                }
            } catch (e: Exception) {
                Log.e("ERROR", "Falló el método para obtener superhéroes", e)
            }
        }
    }
}