package com.example.postapi.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.postapi.Network.ApiInterface
import com.example.postapi.Network.NetworkUtilities
import com.example.postapi.model.ModelData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Repository {
     fun getBgApi(request:HashMap<String,String>): LiveData<ModelData> {
        val liveData = MutableLiveData<ModelData>()

        NetworkUtilities.apiService.getApi(request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                liveData.value = response
            }, { error ->
            })

        return liveData
    }
}