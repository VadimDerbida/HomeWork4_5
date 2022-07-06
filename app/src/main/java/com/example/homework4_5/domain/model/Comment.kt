package com.example.homework4_5

import androidx.annotation.DrawableRes

data class Comment(
    @DrawableRes val authorImage: Int,
    val authorName: String,
    val comment: String
)
