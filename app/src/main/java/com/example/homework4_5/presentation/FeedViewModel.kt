package com.example.homework4_5.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework4_5.domain.model.Comment
import com.example.homework4_5.R
import com.example.homework4_5.domain.model.FeedPost
import com.example.homework4_5.domain.state.FeedUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor() : ViewModel() {
    private val _feedUiState =
        MutableStateFlow(FeedUiState(loading = true, error = null, data = listOf()))
    val feedUiState = _feedUiState.asStateFlow()

    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            val posts = listOf(
                FeedPost(
                    id = 1,
                    authorName = "Vadim Derbida",
                    authorImage = R.drawable.vadim,
                    postImage = R.drawable.landscape,
                    likeCounter = 5000,
                    comments = listOf(
                        Comment(
                            id = 1,
                            authorName = "Daniil Hozhenko: ",
                            authorImage = R.drawable.daniil,
                            comment = "What a bebra"
                        ),
                        Comment(
                            id = 2,
                            authorName = "Daniil Hozhenko: ",
                            authorImage = R.drawable.daniil,
                            comment = "What a bebra"
                        ),
                        Comment(
                            id = 3,
                            authorName = "Daniil Hozhenko: ",
                            authorImage = R.drawable.daniil,
                            comment = "What a bebra"
                        ),
                        Comment(
                            id = 4,
                            authorName = "Daniil Hozhenko: ",
                            authorImage = R.drawable.daniil,
                            comment = "Sanya gay"
                        ),
                        Comment(
                            id = 5,
                            authorName = "Daniil Hozhenko: ",
                            authorImage = R.drawable.daniil,
                            comment = "Nice cock"
                        ),
                        Comment(
                            id = 6,
                            authorName = "Daniil Hozhenko: ",
                            authorImage = R.drawable.daniil,
                            comment = "What a bebra"
                        ),
                        Comment(
                            id = 7,
                            authorName = "Daniil Hozhenko: ",
                            authorImage = R.drawable.daniil,
                            comment = "What a bebra"
                        )
                    ),
                    isLiked = false
                ),
                FeedPost(
                    id = 2,
                    authorName = "Daniil Hozhenko",
                    authorImage = R.drawable.daniil,
                    postImage = R.drawable.landscape_2,
                    likeCounter = 3000,
                    comments = listOf(
                        Comment(
                            id = 1,
                            authorName = "Vadim Derbida: ",
                            authorImage = R.drawable.vadim,
                            comment = "KEKW"
                        )
                    ),
                    isLiked = true
                ),
                FeedPost(
                    id = 3,
                    authorName = "Oleg Saievich",
                    authorImage = R.drawable.oleh,
                    postImage = R.drawable.landscape_3,
                    likeCounter = -1000,
                    comments = listOf(
                        Comment(
                            id = 1,
                            authorName = "Vadim Derbida: ",
                            authorImage = R.drawable.vadim,
                            comment = "KEKW"
                        ),
                        Comment(
                            id = 3,
                            authorName = "Daniil Hozhenko: ",
                            authorImage = R.drawable.daniil,
                            comment = "KEKW + KEKW"
                        ),
                        Comment(
                            id = 4,
                            authorName = "Sasha Prokipchuk:  ",
                            authorImage = R.drawable.sanya,
                            comment = "KEKW - KEKW"
                        ),
                        Comment(
                            id = 5,
                            authorName = "Ilya Nosulich: ",
                            authorImage = R.drawable.ilya,
                            comment = "KEKW / KEKW"
                        )
                    ),
                    isLiked = false
                ),
                FeedPost(
                    id = 4,
                    authorName = "Sasha Prokipchuk:  ",
                    authorImage = R.drawable.sanya,
                    postImage = R.drawable.landscape_4,
                    likeCounter = 2420,
                    comments = listOf(
                        Comment(
                            id = 1,
                            authorName = "Vadim Derbida: ",
                            authorImage = R.drawable.vadim,
                            comment = "KEKW"
                        ),
                        Comment(
                            id = 2,
                            authorName = "Daniil Hozhenko: ",
                            authorImage = R.drawable.daniil,
                            comment = "KEKW + KEKW"
                        ),
                        Comment(
                            id = 3,
                            authorName = "Ilya Nosulich: ",
                            authorImage = R.drawable.ilya,
                            comment = "KEKW - KEKW"
                        ),
                        Comment(
                            id = 4,
                            authorName = "Oleh Saievich: ",
                            authorImage = R.drawable.oleh,
                            comment = "KEKW / KEKW"
                        )
                    ),
                    isLiked = true
                ),
                FeedPost(
                    id = 5,
                    authorName = "Ilya Nosulich",
                    authorImage = R.drawable.ilya,
                    postImage = R.drawable.landscape_5,
                    likeCounter = 94000,
                    comments = listOf(
                        Comment(
                            id = 1,
                            authorName = "Vadim Derbida: ",
                            authorImage = R.drawable.vadim,
                            comment = "KEKW"
                        ),
                        Comment(
                            id = 2,
                            authorName = "Daniil Hozhenko: ",
                            authorImage = R.drawable.daniil,
                            comment = "KEKW + KEKW"
                        ),
                        Comment(
                            id = 3,
                            authorName = "Sasha Prokipchuk:  ",
                            authorImage = R.drawable.sanya,
                            comment = "KEKW - KEKW"
                        ),
                        Comment(
                            id = 4,
                            authorName = "Oleh Saievich: ",
                            authorImage = R.drawable.oleh,
                            comment = "KEKW / KEKW"
                        )
                    ),
                    isLiked = true
                )
            )
            delay(1000)
            _feedUiState.update { uiState ->
                uiState.copy(loading = false, data = posts)
            }
        }
    }

    fun updateLike(post: FeedPost) {
        viewModelScope.launch(Dispatchers.IO) {
            _feedUiState.update { state ->
                state.copy(
                    data = state.data.map {
                        if (it.id == post.id) {
                            it.copy(
                                isLiked = !it.isLiked,
                                likeCounter = if (!it.isLiked) it.likeCounter + 1 else it.likeCounter - 1
                            )
                        } else {
                            it.copy()
                        }
                    })
            }
        }
    }
}