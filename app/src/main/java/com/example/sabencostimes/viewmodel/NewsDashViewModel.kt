package com.example.sabencostimes.viewmodel

import android.util.Log
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.sabencostimes.domain.NYTNewsDataDomain
import com.example.sabencostimes.internet.Connect
import com.example.sabencostimes.internet.NYTimesURL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsDashViewModel(val newsType:Int):ViewModel() {

    private val _newsList = MutableLiveData<List<NYTNewsDataDomain>>()
    val newsList:LiveData<List<NYTNewsDataDomain>>
    get() = _newsList



    init {
        getNews()
}

    fun getNews(){
        getNewsFromNewsType(0)
    }

    fun setNewsById(type:Int){
        getNewsFromNewsType(type)
    }
    private fun getNewsFromNewsType(type:Int){
        viewModelScope.launch(Dispatchers.IO) {
            val connect = Connect()
//                val data = connect.getData("https://rss.nytimes.com/services/xml/rss/nyt/Business.xml")
//                val channel = connect.parseXML(data)
//                _newsList.postValue(channel)
//            }
            try {
                val newsURL = type.let {
                    if(it == 0) return@let NYTimesURL.BUSINESS_NEWS
                    else return@let NYTimesURL.MIDDLE_EAST_NEWS
                }
                val data = connect.getData(newsURL)
                val channel = connect.parseXML(data)
                _newsList.postValue(channel)
            }
            catch (exception:Exception){
                Log.v("nytNews",exception.toString())
            }

        }
    }
}


class NewsDashModelFactory(private val newsType: Int) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T = NewsDashViewModel(newsType) as T
}