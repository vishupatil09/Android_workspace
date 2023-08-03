package com.example.webview

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

        // Load the Google URL into the WebView
        webView.loadUrl("https://www.google.com")

        // Set a WebViewClient to manage forward and backward navigation
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }
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
