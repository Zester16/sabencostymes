package com.example.sabencostimes.repository

import android.util.Log
import com.example.sabencostimes.domain.NYTNewsDataDomain
import com.example.sabencostimes.network.xml.parser.Connect
import com.example.sabencostimes.network.xml.parser.NYTimesURL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NYTNewsRepository(val connectData: Connect) {

    suspend fun getNYTFrontPageNews():List<NYTNewsDataDomain>{
        return withContext(Dispatchers.IO){
            try{
                return@withContext getDataAndParse(NYTimesURL.HOME_PAGE_NEWS)
            }
            catch(exception:Exception){
                Log.v("NYTNewsRepository-getNYTFrontPageNews",exception.toString())
                return@withContext emptyList()

            }


        }
    }

    private suspend fun getDataAndParse(url:String):List<NYTNewsDataDomain>{

        return withContext(Dispatchers.IO){
            val data =connectData.getData(url)
            return@withContext  connectData.parseXML(data)
        }


    }
}