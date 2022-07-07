package com.example.homework4_5.domain.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Comment(
    @DrawableRes val authorImage: Int,
    val id: Int,
    val authorName: String,
    val comment: String
) : Parcelable
