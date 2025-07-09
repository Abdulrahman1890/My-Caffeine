package com.example.mycaffeine.domian

import androidx.annotation.DrawableRes

data class CoffeeCupImages(
    @DrawableRes val mainImage: Int,
    @DrawableRes val coverImage: Int,
    @DrawableRes val topViewImage: Int,
    @DrawableRes val emptyCupImage: Int
)