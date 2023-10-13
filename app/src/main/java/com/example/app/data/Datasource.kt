package com.example.app.data

import com.example.app.R
import com.example.app.model.Movie

class Datasource {
    fun loadMovies(): List<Movie> {
        return listOf<Movie>(
            Movie(R.string.id1, R.string.movie1, R.drawable.di_ambang_kematian, R.string.dur_movie1),
            Movie(R.string.id2, R.string.movie2, R.drawable.pamali, R.string.dur_movie2),
            Movie(R.string.id3, R.string.movie3, R.drawable.petualangan_sherina, R.string.dur_movie3),
            Movie(R.string.id4, R.string.movie4, R.drawable.saw_x, R.string.dur_movie4)
        )
    }
}