package com.example.sabencostimes.network.xml.parser

import android.util.Log
import com.example.sabencostimes.domain.NYTMarketApiDomain
import com.example.sabencostimes.domain.NYTNewsLetterDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject

class KotlinJsonConnect {
    suspend fun parseNYTimesStockJSon(jsonObject:String):List<NYTMarketApiDomain>{
        return withContext(Dispatchers.IO){
            try {
            val obj =  JSONObject(jsonObject)

            val datas = obj.getJSONArray("data")
            val dataArray= mutableListOf<NYTMarketApiDomain>()
            Log.v("api datas",datas.toString())
            var i =0
            while(i < datas.length()){
                val data = datas.get(i)
                val dataObject =datas.getJSONObject(i)

                val newData = NYTMarketApiDomain(name=dataObject.getString("identifier"), points = dataObject.getDouble("last"), percentageChange =dataObject.getDouble("changePercent"), timestamp = dataObject.getString("lastTimestamp") )
                dataArray.add(newData)

                i++
            }
            Log.v("api datas",dataArray.toString())
                return@withContext dataArray
        } catch (exception: Exception) {
                Log.e("api datas error", exception.toString())
                return@withContext mutableListOf<NYTMarketApiDomain>()
            }

        }
    }
    suspend fun getNYTimesNews(jsonString: String):MutableList<NYTNewsLetterDomain>{

        return withContext(Dispatchers.IO){
            try{

                val jsonArray = JSONArray(jsonString)

                Log.v("network-xml.parser-Kotlinconnect:getNYTNews",jsonArray.toString())

                var i = 0
                val nytNewsLetterDomainArray = mutableListOf<NYTNewsLetterDomain>()

                while ( i < jsonArray.length() ){
                    val dataObject =jsonArray.getJSONObject(i)
                    nytNewsLetterDomainArray.add(NYTNewsLetterDomain(title = dataObject.getString("title"), date = dataObject.getString("date" ), imgSrc = dataObject.getString("img"), url = dataObject.getString("url")))
               i++
                }

                return@withContext nytNewsLetterDomainArray
        }
            catch (exception:Exception){
                Log.v("",exception.toString())
                return@withContext mutableListOf<NYTNewsLetterDomain>()
            }            }
    }
}