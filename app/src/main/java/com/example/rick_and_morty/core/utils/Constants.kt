package com.example.rick_and_morty.core.utils

import com.example.rick_and_morty.R
import com.example.rick_and_morty.core.composables.BottomAppBarItem

object Constants {
    const val BASE_URL = "https://rickandmortyapi.com/api/"

    val items = listOf(
        BottomAppBarItem(R.drawable.ramhome,R.drawable.wow, R.string.characters, "home"),
        BottomAppBarItem(R.drawable.location,R.drawable.loc, R.string.location, "location"),
        BottomAppBarItem(R.drawable.episodes,R.drawable.epi, R.string.episodes, "episodes"),
        )
}