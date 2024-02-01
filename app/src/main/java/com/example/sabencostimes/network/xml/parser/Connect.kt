package com.example.sabencostimes.network.xml.parser

import android.util.Log
import com.example.sabencostimes.domain.NYTNewsDataDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import org.xml.sax.InputSource
import java.io.StringReader
import java.net.URL
import javax.xml.parsers.DocumentBuilderFactory

class Connect {

    suspend fun getData(url: String):String {
        val url = URL(url)
        return withContext(Dispatchers.IO) {
//        with(url.openConnection() as HttpURLConnection) {
//            requestMethod = "GET"  // optional default is GET
//
//            println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")
//
//            inputStream.bufferedReader().use {
//                println(it.toString())
//            }
//        }
            //var text = ""
            //text += url.readText()
            //println("Data is:"+text)
            return@withContext url.readText()
        }

    }

}

