package com.example.sabencostimes.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import com.example.sabencostimes.navigation.NavigationConstant

fun convertDoubleToStringFormat(number:Double):String{
    return String.format("%.2f",number)
}

//for invoking navigation to browser, since it takes data from path param
fun invokeNavigationToInternalWebBrowser(url:String, navHostController:NavHostController){
    navHostController.navigate(NavigationConstant.WEB_VIEW_PATH.replace("{webUrl}",url))
}

//invoking navigation to external default browser
fun invokeNavigationToExternalWebBrowser(url:String,context:Context){
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    ContextCompat.startActivity(context, intent, null)
}