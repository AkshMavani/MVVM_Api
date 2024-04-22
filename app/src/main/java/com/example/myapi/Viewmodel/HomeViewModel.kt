package com.example.myapi.Viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.myapi.Network.ApiInterface
import com.example.myapi.Network.NetworkUtilities
import com.example.myapi.Response.ResponseData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel {
    private lateinit var subscription: Disposable
    private val apiService: ApiInterface = NetworkUtilities.getClient()

    var mutImageAPIResponse: MutableLiveData<ResponseData> =
        MutableLiveData()

    /**         Fetching Top Coins Pair List API Call      **/
    fun onTopCoinsPairListAPICall() {
        subscription = apiService.getResponse()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .unsubscribeOn(Schedulers.io())
            .subscribe { result -> onExchangeTopCoinsPairListSuccess(result) }
    }

    private fun onExchangeTopCoinsPairListSuccess(result: ResponseData) {
        mutImageAPIResponse.value = result
    }
}