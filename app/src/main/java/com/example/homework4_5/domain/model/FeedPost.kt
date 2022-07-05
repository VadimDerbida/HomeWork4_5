package com.example.homework4_5.domain.model

import androidx.annotation.DrawableRes
import com.example.homework4_5.Comment


data class FeedPost(
    val id: Int,
    val authorName: String,
    @DrawableRes val authorImage: Int,
    @DrawableRes val postImage: Int,
    val likeCounter: Int,
    val comments: List<Comment>,
    val isLiked: Boolean
)
