package com.example.cleandictionary.feature_dictionary.data.remote.dto

import com.example.cleandictionary.feature_dictionary.domain.model.Meaning
import com.google.gson.annotations.SerializedName

data class WordInfo(
    @field:SerializedName("phonetic")
    val phonetic: String,

    @field:SerializedName("origin")
    val origin: String,

    @field:SerializedName("word")
    val word: String,

    @field:SerializedName("meanings")
    val meanings: List<Meaning>
)
