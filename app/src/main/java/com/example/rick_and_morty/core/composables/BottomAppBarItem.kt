package com.example.rick_and_morty.core.composables

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class BottomAppBarItem(
    @DrawableRes val icon: Int,
    @StringRes val title: Int,
     val route: String
)
