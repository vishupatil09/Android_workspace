package com.example.webview


import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.web)
        webView.settings.javaScriptEnabled = true // Enable JavaScript for the webpage

        if (isInternetAvailable()) {
           
            webView.loadUrl("https://www.google.com")

           
            webView.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                        view?.loadUrl(url!!)

                    return true
                }
            }
        } else {
           Toast.makeText(this, "No internet connection.", Toast.LENGTH_LONG).show()
        }
    }

    
    private fun isInternetAvailable(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connectivityManager.activeNetwork ?: return false
        val activeNetwork =
            connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false

        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    }

   
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack() // Go back if there's a previous page in the WebView history
        } else {
            super.onBackPressed() // Otherwise, exit the activity
        }
    }
}
