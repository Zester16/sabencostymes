package com.example.sabencostimes.network.xml.parser

import android.util.Log
import com.example.sabencostimes.domain.NYTMarketApiDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject

class KotlinJsonConnect {
    suspend fun parseJSon(jsonObject:String):List<NYTMarketApiDomain>{
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
}