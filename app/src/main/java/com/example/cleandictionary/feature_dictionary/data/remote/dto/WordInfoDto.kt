package com.example.cleandictionary.feature_dictionary.data.remote.dto

import android.os.Parcelable
import com.example.cleandictionary.feature_dictionary.data.local.entity.WordInfoEntity
import com.example.cleandictionary.feature_dictionary.domain.model.Definition
import com.example.cleandictionary.feature_dictionary.domain.model.Meaning
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class WordInfoDto(
    @field:SerializedName("phonetic")
    val phonetic: String?,

    @field:SerializedName("origin")
    val origin: String?,

    @field:SerializedName("phonetics")
    val phonetics: List<PhoneticsDto>,

    @field:SerializedName("word")
    val word: String?,

    @field:SerializedName("meanings")
    val meanings: List<MeaningsDto>
) : Parcelable {

    fun toWordInfoEntity(): WordInfoEntity = WordInfoEntity(
        word?:"", phonetic?:"", origin?:"", meanings.map { it.toMeaning() }
    )

    @Parcelize
    data class PhoneticsDto(
        @field:SerializedName("text")
        val text: String,

        @field:SerializedName("audio")
        val audio: String
    ) : Parcelable

    @Parcelize
    data class MeaningsDto(
        @field:SerializedName("partOfSpeech")
        val partOfSpeech: String,

        @field:SerializedName("definitions")
        val definitions: List<DefinitionsDto>
    ) : Parcelable {
        fun toMeaning(): Meaning = Meaning(
            partOfSpeech, definitions.map { it.toDefinition() }
        )
    }

    @Parcelize
    data class DefinitionsDto(
        @field:SerializedName("synonyms")
        val synonyms: List<String>,

        @field:SerializedName("antonyms")
        val antonyms: List<String>,

        @field:SerializedName("definition")
        val definition: String,

        @field:SerializedName("example")
        val example: String?
    ) : Parcelable {
        fun toDefinition(): Definition = Definition(
            synonyms, antonyms, definition, example
        )
    }
}

