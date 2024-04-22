package com.example.myapi.Network


import com.example.myapi.Response.ResponseData
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {
    @GET(URL)
    fun getResponse(): Observable<ResponseData>
    companion object{
        const val URL="search?country=United+States"
    }
}