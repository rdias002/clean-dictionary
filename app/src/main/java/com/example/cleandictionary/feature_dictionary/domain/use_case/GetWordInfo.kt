package com.example.cleandictionary.feature_dictionary.domain.use_case

import com.example.cleandictionary.core.util.Resource
import com.example.cleandictionary.feature_dictionary.data.remote.dto.WordInfo
import com.example.cleandictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(
    private val repository: WordInfoRepository
) {

    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>>{
        if (word.isBlank()) {
            return flow{ }
        }
        return repository.getWordInfo(word)
    }
}