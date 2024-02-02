package com.example.sabencostimes.repository

import com.example.sabencostimes.BuildConfig
import com.example.sabencostimes.domain.NYTNewsLetterDomain
import com.example.sabencostimes.network.xml.parser.Connect
import com.example.sabencostimes.network.xml.parser.KotlinJsonConnect
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NYTNewsLetterRepository(private val connectData: Connect) {

    private val nytNewsParser= KotlinJsonConnect()
    suspend fun getNYTNewsLetter():MutableList<NYTNewsLetterDomain>{
        return withContext(Dispatchers.IO){
            val PRIMARY_STRING= BuildConfig.TIVV_URL.toString()
            val REQ_STRING = PRIMARY_STRING+"/live/nyt-dealbook-array"
            return@withContext getDataAndParse(REQ_STRING)
        }


    }

    private suspend fun getDataAndParse(url:String):MutableList<NYTNewsLetterDomain>{
        return withContext(Dispatchers.IO){
            val data= connectData.getData(url)

            return@withContext nytNewsParser.getNYTimesNews(data)
        }

    }
}