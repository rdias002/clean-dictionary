package com.example.cleandictionary.feature_dictionary.domain.model

import com.example.cleandictionary.feature_dictionary.data.remote.dto.WordInfoDto
import com.google.gson.annotations.SerializedName

data class Meaning(
    @field:SerializedName("partOfSpeech")
    val partOfSpeech: String,

    @field:SerializedName("definitions")
    val definitions: List<Definition>
)