package com.example.homework4_5.domain.state

import com.example.homework4_5.domain.model.FeedPost

data class FeedUiState(
    val loading: Boolean = true,
    val error: String? = null,
    val data: List<FeedPost> = listOf()
)
