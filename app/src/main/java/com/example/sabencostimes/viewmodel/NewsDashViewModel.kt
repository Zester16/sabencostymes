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

    private val _tabIndex = MutableLiveData<Int>()
    val tabIndex:LiveData<Int>
    get() = _tabIndex


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading:LiveData<Boolean>
    get() = _isLoading
    init {
        initNews()
}

    fun initNews(){
        setIsLoadingTrue()
        _tabIndex.value = 0
        getNewsFromNewsType(0)

    }

    fun setNewsById(type:Int){
        setIsLoadingTrue()
        _tabIndex.value = type
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
                _isLoading.postValue(true)
                val newsURL = type.let {
                    if(it == 0) return@let NYTimesURL.BUSINESS_NEWS
                    else if(it == 2) return@let NYTimesURL.ASIA_PACIFIC
                    else return@let NYTimesURL.MIDDLE_EAST_NEWS
                }
                val data = connect.getData(newsURL)
                val channel = connect.parseXML(data)
                _newsList.postValue(channel)
                _isLoading.postValue(false)

            }
            catch (exception:Exception){
                Log.v("nytNews",exception.toString())
                _isLoading.postValue(false)
            }

        }

    }

    private fun setIsLoadingTrue(){
        _isLoading.value = true
    }
    private fun setIsLoadingFalse(){
        _isLoading.value = false
    }
}


class NewsDashModelFactory(private val newsType: Int) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T = NewsDashViewModel(newsType) as T
}