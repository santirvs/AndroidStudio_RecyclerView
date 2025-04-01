package com.example.myapplication.models

import androidx.annotation.DrawableRes

data class Pokemon(
    var name: String,
    var type: String,
    @DrawableRes var image: Int)

