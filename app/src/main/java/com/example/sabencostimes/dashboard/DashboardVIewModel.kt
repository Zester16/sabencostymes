package com.example.sabencostimes.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sabencostimes.domain.NYTMarketApiDomain
import com.example.sabencostimes.domain.NYTNewsDataDomain
import com.example.sabencostimes.network.xml.parser.Connect
import com.example.sabencostimes.network.xml.parser.KotlinJsonConnect
import com.example.sabencostimes.repository.NYTNewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.lang.Exception

private lateinit var nytNewsRepository: NYTNewsRepository
class DashboardViewModel():ViewModel() {

    private val _mainNewsList= MutableLiveData<List<NYTNewsDataDomain>>()
    val newsList:LiveData<List<NYTNewsDataDomain>>
        get() = _mainNewsList

    private val _nytMarketApi = MutableLiveData<List<NYTMarketApiDomain>>()

    val nytMarketApi:LiveData<List<NYTMarketApiDomain>>
        get() = _nytMarketApi

    private val  coroutineJob = Job()
    private val viewmodelScope = CoroutineScope(coroutineJob+Dispatchers.Main)
    override fun onCleared() {
        viewmodelScope.cancel()
        super.onCleared()
    }

    init{
        nytNewsRepository = NYTNewsRepository(Connect())
         getNews()
        getDashData()
    }

    private  fun getNews(){
        viewmodelScope.launch {
            _mainNewsList.value = nytNewsRepository.getNYTFrontPageNews()
            Log.v("Dash", _mainNewsList.value.toString())
        }

    }
    private fun getDashData() {
            val connect = Connect()
            viewmodelScope.launch {
                try {
                val input =  connect.getData("https://www.nytimes.com/api/market")
                _nytMarketApi.postValue(KotlinJsonConnect().parseJSon(input))
            }
                catch (exception:Exception){
                    Log.v("Dashboard Exception", exception.toString())
                }
                catch (error:Error){
                    Log.v("Dashboard Error", error.toString())
                }
        }

    }
}