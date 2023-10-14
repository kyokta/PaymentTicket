package com.example.app.data

import com.example.app.R
import com.example.app.model.Movie

class Datasource {
    fun loadMovies(): List<Movie> {
//        return listOf<Movie>(
//            Movie(R.string.id1, R.string.movie1, R.drawable.di_ambang_kematian, R.string.dur_movie1),
//            Movie(R.string.id2, R.string.movie2, R.drawable.pamali, R.string.dur_movie2),
//            Movie(R.string.id3, R.string.movie3, R.drawable.petualangan_sherina, R.string.dur_movie3),
//            Movie(R.string.id4, R.string.movie4, R.drawable.saw_x, R.string.dur_movie4)
//        )

        return listOf<Movie>(
            Movie(1, "Di Ambang Kematian", R.drawable.di_ambang_kematian, "1 Jam 37 Menit"),
            Movie(2, "Pamali : Dusun Pocong", R.drawable.pamali, "1 Jam 37 Menit"),
            Movie(3, "Petualangan Sherina", R.drawable.petualangan_sherina, "2 Jam 6 Menit"),
            Movie(4, "Saw X", R.drawable.saw_x, "1 Jam 58 Menit")
        )
    }
}