package com.example.mandiryapp.View

import android.webkit.WebView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.example.mandiryapp.Data.Article
import android.util.Log
import android.webkit.WebViewClient

@Composable
fun DetailScreen(article: Article){
    WebViewComposable(url = article.url)
}




@Composable
fun WebViewComposable(url: String) {
    val context = LocalContext.current
    AndroidView(
        factory = {
            WebView(context).apply {
                settings.javaScriptEnabled = true
                webViewClient = object : WebViewClient() {
                    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                        Log.d("WebView", "Loading URL: $url")
                        view?.loadUrl(url ?: "")
                        return true
                    }

                    override fun onReceivedError(
                        view: WebView?,
                        errorCode: Int,
                        description: String?,
                        failingUrl: String?
                    ) {
                        Log.e("WebView", "Error: $description, URL: $failingUrl")
                    }
                }
                loadUrl(url)
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}
