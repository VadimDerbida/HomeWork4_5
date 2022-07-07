package com.example.homework4_5.domain.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class FeedPost(
    val id: Int,
    val authorName: String,
    @DrawableRes val authorImage: Int,
    @DrawableRes val postImage: Int,
    val likeCounter: Int,
    val comments: List <Comment>,
    val isLiked: Boolean
): Parcelable
