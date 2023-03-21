package com.example.sabencostimes.domain

import com.example.sabencostimes.parceable.NYTNewsParceable

data class NYTNewsDataDomain(val title:String?,val description:String?, val url:String?, val imageURL:String?)

fun NYTNewsDataDomain.toParceable():NYTNewsParceable{
    return NYTNewsParceable(title = this.title,description=this.description,url=this.url,imageURL=this.imageURL)
}