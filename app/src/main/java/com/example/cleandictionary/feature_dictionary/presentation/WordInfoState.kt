package com.example.cleandictionary.feature_dictionary.presentation

import com.example.cleandictionary.feature_dictionary.data.remote.dto.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)
