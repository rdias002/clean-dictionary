package com.example.cleandictionary.feature_dictionary.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Definition(
    @field:SerializedName("synonyms")
    val synonyms: List<String>,

    @field:SerializedName("antonyms")
    val antonyms: List<String>,

    @field:SerializedName("definition")
    val definition: String,

    @field:SerializedName("example")
    val example: String?
) : Parcelable