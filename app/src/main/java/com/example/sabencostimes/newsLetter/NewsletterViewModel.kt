package com.example.sabencostimes.newsLetter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sabencostimes.domain.NYTNewsLetterDomain
import com.example.sabencostimes.repository.NYTNewsLetterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class NewsletterViewModel(private val repository: NYTNewsLetterRepository,private val newsKey:String):ViewModel() {

    private val job = Job()
    private val viewModelJob = CoroutineScope(Dispatchers.Main+job)
    private val _newsLetterList=MutableLiveData<List<NYTNewsLetterDomain>>()
    val newsLetterList:LiveData<List<NYTNewsLetterDomain>>
        get() = _newsLetterList
    override fun onCleared() {
        viewModelJob.cancel()
        super.onCleared()
    }

    init {
        getNewsLetter()
    }

    fun getNewsLetter(){
        viewModelJob.launch {
            try {
                _newsLetterList.value= repository.getNYTNewsLetter(newsKey =newsKey )

            }
            catch(e:Exception){
                Log.v("newslettervm $newsKey",e.toString())
            }
                  }
    }
}

class NewsLetterViewModelFactory(private val repository: NYTNewsLetterRepository, private val newsKey: String):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T = NewsletterViewModel(repository,newsKey) as T


}