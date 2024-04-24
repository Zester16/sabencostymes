package com.example.sabencostimes.webview

import android.os.Build
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController

@RequiresApi(Build.VERSION_CODES.O)
@Composable
//this web view takes into cognizant of saved account. if user has access to nytimes, user can access it
fun NewsWebView( navController:NavHostController,newsUrl:String) {
    val trialUrl ="https://www.nytimes.com/series/asia-australia-morning-briefing"
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            this.settings.safeBrowsingEnabled = true
            this.getSettings().userAgentString="Mozilla/5.0 (Linux; Android 8.0; Pixel 2 Build/OPD3.170816.012) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.82 Mobile Safari/537.36"
            this.canGoBackOrForward(3)
            this.clearHistory()
            this.settings.javaScriptEnabled = true
            loadUrl(newsUrl)
        }
    }, update = {
        it.loadUrl(newsUrl)
    })

}
@Composable
fun NewsWebViewNoJs(navController: NavHostController,newsUrl: String){
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()

            loadUrl(newsUrl)
            this.clearHistory()
        }
    }, update = {
        it.loadUrl(newsUrl)
    })
}