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
            // Internet is available, load the Google URL into the WebView
            webView.loadUrl("https://www.google.com")

            // Set a WebViewClient to manage forward and backward navigation
            webView.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                        view?.loadUrl(url!!)

                    return true
                }
            }
        } else {
            // Internet is not available, handle the error here (e.g., show a toast)
            // You can customize this part to show an error message to the user
        }
    }

    // Function to check internet connectivity
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

    // Override the onBackPressed method to handle WebView navigation
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack() // Go back if there's a previous page in the WebView history
        } else {
            super.onBackPressed() // Otherwise, exit the activity
        }
    }
}
