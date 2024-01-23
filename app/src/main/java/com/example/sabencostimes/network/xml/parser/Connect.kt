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
    suspend fun parseXML(input:String):List<NYTNewsDataDomain>{

       return  withContext(Dispatchers.IO){
            val dbf = DocumentBuilderFactory.newInstance()
            val doc = dbf.newDocumentBuilder().parse(InputSource(StringReader(input)))
            doc.getDocumentElement().normalize()
            val items:NodeList = doc.getElementsByTagName("item")
           var domain = mutableListOf<NYTNewsDataDomain>()
           for(i in 0 until items.length){
                val item:Node = items.item(i)
               val element: Element = item as Element
                val title = element.getElementsByTagName("title").item(0).childNodes.item(0).nodeValue
                val description = element.getElementsByTagName("description")?.item(0)?.childNodes?.item(0)?.nodeValue
               val url = element.getElementsByTagName("link").item(0).childNodes.item(0).nodeValue
               val image = element.getElementsByTagName("media:content")?.item(0)?.attributes?.getNamedItem("url")?.nodeValue
               domain.add(NYTNewsDataDomain(title = title, description = description, imageURL = image, url = url))
                Log.v("item",element.getElementsByTagName("media:content")?.item(0)?.attributes?.getNamedItem("url")?.nodeValue.toString())
       }
            return@withContext domain


        }


    }
}