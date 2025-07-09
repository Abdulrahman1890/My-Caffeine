package com.example.mycaffeine.domian

import androidx.annotation.DrawableRes

data class Snacks (
    val id: Int,
    val name: String,
    @DrawableRes val imageRes: Int
)