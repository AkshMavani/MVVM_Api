package com.example.postapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.myapi.R
import com.example.postapi.Viewmodel.BgViewModel

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val viewModel = ViewModelProvider(this)[BgViewModel::class.java]
        /*   viewModel.getBg(hashMap)*/
        viewModel.live.observe(this){ response->
            Log.e("response", "onCreate: >>${response.data}" )
        }
    }
}