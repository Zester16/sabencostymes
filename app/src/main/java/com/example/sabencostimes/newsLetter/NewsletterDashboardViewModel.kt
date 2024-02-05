package com.example.sabencostimes.newsLetter

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

class NewsletterDashboardViewModel(private val repository: NYTNewsLetterRepository):ViewModel() {

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
           _newsLetterList.value= repository.getNYTNewsLetter()
        }
    }
}

class NewsLetterViewModelFactory(private val repository: NYTNewsLetterRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T = NewsletterDashboardViewModel(repository) as T


}