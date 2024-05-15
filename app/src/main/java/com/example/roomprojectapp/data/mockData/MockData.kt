package com.example.roomprojectapp.data.mockData

import com.example.roomprojectapp.domain.models.Superhero

class MockData {
    companion object {
        val superheroes = listOf<Superhero>(
            Superhero(
                1,
                "Spider-Man",
                0, // Marvel
                "Heroe",
                "https://pngbuy.com/wp-content/uploads/2023/05/transparent-spiderman-png.png"
            ),
            Superhero(
                2,
                "Batman",
                1, // DC
                "Heroe",
                "https://pngbuy.com/wp-content/uploads/2023/05/batman-png-1.png"
            ),
            Superhero(
                3,
                "Iron Man",
                0, // Marvel
                "Heroe",
                "https://ongpng.com/wp-content/uploads/2023/04/7.ironman-784x768-1.png"
            ),
            Superhero(
                4,
                "Joker",
                1, // DC
                "Villano",
                "https://i.pinimg.com/236x/75/29/ca/7529ca0c2a8fda6e61123e6bdffa3f38.jpg"
            ),

        )
    }
}