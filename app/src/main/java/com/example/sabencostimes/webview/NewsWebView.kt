package com.example.sabencostimes.webview

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController

@Composable
fun NewsWebView( navController:NavHostController,newsUrl:String) {
    val trialUrl ="https://www.nytimes.com/series/asia-australia-morning-briefing"
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            this.settings.javaScriptEnabled = true
            loadUrl(newsUrl)
        }
    }, update = {
        it.loadUrl(newsUrl)
    })


}