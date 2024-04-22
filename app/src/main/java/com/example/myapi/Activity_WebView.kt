package com.example.myapi

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class Activity_WebView : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        val web:WebView=findViewById(R.id.webView)
        val URL=intent.getStringExtra("URL")
        web.getSettings().setJavaScriptEnabled(true);
        URL?.let { web.loadUrl(it) }
    }
}