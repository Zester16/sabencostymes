package com.example.sabencostimes.domain

import com.example.sabencostimes.R

//for data
class NYTNewsLetterDomain(val title:String, val date:String, val imgSrc:String, val url:String)

//for setting up switch variables
const val NYT_DEALBOOK="nyt_dealbook"
const val NYT_MORNING_AUS = "nyt_morning_aus"
const val NYT_MORNING_APAC = "nyt_morning_apac"
const val NYT_MORNING_EUROPE = "nyt_morning_europe"
const val NYT_MORNING_US = "nyt_morning_us"
const val NYT_EVENING_US = "nyt_evening_us"

//val NYTNewsletterURLMap= mapOf<String,String>(
//    NYT_DEALBOOK to "/nyt-newsletter?topic=${NYT_DEALBOOK}",
//    NYT_MORNING_AUS to "/nyt-newsletter?topic=${NYT_MORNING_AUS}",
//    NYT_MORNING_EUROPE to "/nyt-newsletter?topic=${NYT_MORNING_EUROPE}"
//)

data class NYTNewsletterStruct(val url: String,val image:Int)
val NYTNewsletterURLMap= mapOf<String,NYTNewsletterStruct>(
    NYT_DEALBOOK to NYTNewsletterStruct(url = "/nyt-newsletter?topic=${NYT_DEALBOOK}",image= R.drawable.nyt_dealbook_125),
    NYT_MORNING_AUS to NYTNewsletterStruct(url="/nyt-newsletter?topic=${NYT_MORNING_AUS}",image= R.drawable.nyt_aus_newsletter_logo),
    NYT_MORNING_APAC to NYTNewsletterStruct(url="/nyt-newsletter?topic=${NYT_MORNING_APAC}", image = R.drawable.nyt_apac_newsletter_logo),
    NYT_MORNING_EUROPE to NYTNewsletterStruct(url = "/nyt-newsletter?topic=${NYT_MORNING_EUROPE}", image =R.drawable.nyt_europe_newsletter_logo),
    NYT_MORNING_US to NYTNewsletterStruct(url = "/nyt-newsletter?topic=${NYT_MORNING_US}", image =R.drawable.nyt_usa_newsleter_morning),
    NYT_EVENING_US to NYTNewsletterStruct(url = "/nyt-newsletter?topic=${NYT_EVENING_US}", image =R.drawable.nyt_usa_evening_newsletter_logo)
)