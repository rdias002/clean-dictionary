package com.example.cleandictionary.feature_dictionary.domain.repository

import com.example.cleandictionary.core.util.Resource
import com.example.cleandictionary.feature_dictionary.data.remote.dto.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {
    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}