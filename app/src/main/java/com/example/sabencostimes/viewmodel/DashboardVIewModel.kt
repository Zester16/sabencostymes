package com.example.sabencostimes.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sabencostimes.domain.NYTNewsDataDomain
import com.example.sabencostimes.network.Connect
import com.example.sabencostimes.repository.NYTNewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

private lateinit var nytNewsRepository: NYTNewsRepository
class DashboardViewModel():ViewModel() {

    private val _mainNewsList= MutableLiveData<List<NYTNewsDataDomain?>>()
    val newsList:LiveData<List<NYTNewsDataDomain?>>
        get() = _mainNewsList
    private val  coroutineJob = Job()
    private val viewmodelScope = CoroutineScope(coroutineJob+Dispatchers.Main)
    override fun onCleared() {
        viewmodelScope.cancel()
        super.onCleared()
    }

    init{
        nytNewsRepository = NYTNewsRepository(Connect())
    getNews()
    }

    private  fun getNews(){
        viewmodelScope.launch {
            _mainNewsList.value = nytNewsRepository.getNYTFrontPageNews()
            Log.v("Dash", _mainNewsList.value.toString())
        }

    }
}