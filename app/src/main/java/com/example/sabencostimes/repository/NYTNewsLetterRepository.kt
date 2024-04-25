package com.example.sabencostimes.repository

import com.example.sabencostimes.BuildConfig
import com.example.sabencostimes.domain.NYTNewsLetterDomain
import com.example.sabencostimes.domain.NYTNewsletterURLMap
import com.example.sabencostimes.network.xml.parser.Connect
import com.example.sabencostimes.network.xml.parser.KotlinJsonConnect
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NYTNewsLetterRepository(private val connectData: Connect) {

    private val nytNewsParser= KotlinJsonConnect()
    suspend fun getNYTNewsLetter(newsKey:String):MutableList<NYTNewsLetterDomain>{
        return withContext(Dispatchers.IO){
            val checkKey =NYTNewsletterURLMap.containsKey(newsKey)
            if(!checkKey){
                throw Exception("nyt-news-parser: No nytKey found")
            }
            val SUFFIX_URL= NYTNewsletterURLMap.get(newsKey)?.url
            val PRIMARY_STRING= BuildConfig.TIVV_URL.toString()
            //"/live/nyt-dealbook-array"
            val REQ_STRING = PRIMARY_STRING+SUFFIX_URL
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