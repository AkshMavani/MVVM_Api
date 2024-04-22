package com.example.myapi

import android.annotation.SuppressLint
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapi.Response.ResponseData
import com.example.myapi.Viewmodel.HomeViewModel

class MainActivity : AppCompatActivity() {
     var viewModel= HomeViewModel()
    val arr:ArrayList<ResponseData> = ArrayList()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView:RecyclerView=findViewById(R.id.recycleView)
        val progressbarDialog=ProgressDialog(this)
        progressbarDialog.setCancelable(false)
        progressbarDialog.setMessage("please wait...")
        progressbarDialog.show()
        recyclerView.layoutManager=LinearLayoutManager(this)
        viewModel.onTopCoinsPairListAPICall()
        viewModel.mutImageAPIResponse.observe(this, Observer {
            if (it!=null){
                progressbarDialog.dismiss()
                arr.clear()
                for (i in it){
                    arr.add(it)
                }
                val adapter=Adapter(arr,this)
                recyclerView.adapter=adapter
            }
        })

    }
}