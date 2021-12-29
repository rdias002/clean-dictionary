package com.example.cleandictionary.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cleandictionary.feature_dictionary.data.remote.dto.WordInfo
import com.example.cleandictionary.feature_dictionary.domain.model.Meaning

@Entity
data class WordInfoEntity(
    val word: String,
    val phonetic: String,
    val origin: String,
    val meanings: List<Meaning>,
    @PrimaryKey val id: Int? = null
){
    fun toWordInfo() : WordInfo = WordInfo(
        phonetic, origin, word, meanings
    )
}
