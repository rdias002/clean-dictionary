package com.example.cleandictionary.feature_dictionary.data.repository

import android.util.Log
import com.example.cleandictionary.core.util.Resource
import com.example.cleandictionary.feature_dictionary.data.local.WordInfoDao
import com.example.cleandictionary.feature_dictionary.data.remote.DictionaryApi
import com.example.cleandictionary.feature_dictionary.data.remote.dto.WordInfo
import com.example.cleandictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
): WordInfoRepository {

    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow{
        emit(Resource.Loading())

        val wordInfos = dao.getWordInfo(word).map { it.toWordInfo() }
        emit(Resource.Loading(wordInfos))

        try {
            val remoteWordInfos = api.getWordInfo(word)
            dao.deleteWordInfos(remoteWordInfos.map { it.word.toString() })
            dao.insertWordInfos(remoteWordInfos.map { it.toWordInfoEntity() })
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Resource.Error(
                "Oops, something went wrong",
                wordInfos
            ))
        } catch (e: IOException){
            e.printStackTrace()
            emit(Resource.Error(
                "Oops, something went wrong",
                wordInfos
            ))
        }

        val newWordInfos = dao.getWordInfo(word).map { it.toWordInfo() }
        emit(Resource.Success(newWordInfos))
    }
}