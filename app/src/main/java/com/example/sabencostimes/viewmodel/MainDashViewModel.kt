package com.example.sabencostimes.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sabencostimes.domain.NYTNewsDataDomain
import com.example.sabencostimes.internet.Connect
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainDashViewModel:ViewModel() {

    private val _newsList = MutableLiveData<List<NYTNewsDataDomain>>()
    val newsList:LiveData<List<NYTNewsDataDomain>>
    get() = _newsList



    init {
        viewModelScope.launch(Dispatchers.IO) {
             val connect = Connect()
//                val data = connect.getData("https://rss.nytimes.com/services/xml/rss/nyt/Business.xml")
//                val channel = connect.parseXML(data)
//                _newsList.postValue(channel)
//            }
            try {
                val data = connect.getData("https://rss.nytimes.com/services/xml/rss/nyt/Business.xml")
                val channel = connect.parseXML(data)
                _newsList.postValue(channel)
            }
            catch (exception:Exception){
                Log.v("nytNews",exception.toString())
            }

        }
    }
}