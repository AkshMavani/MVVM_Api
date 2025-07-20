package com.example.postapi.Viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.postapi.model.ModelData
import com.example.postapi.repo.Repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

open class BgViewModel:ViewModel() {
    private val repository = Repository()
    val bgLiveData=MutableLiveData<ModelData>()
    val live:LiveData<ModelData> = bgLiveData
    init {

        val hashMap = HashMap<String, String>()
        hashMap["appkey"] = "ghantzmanga@123"
        hashMap["device"] = "apple"
        hashMap["os"] = "ios"
        hashMap["version"] = "15"
        hashMap["category"] = "bg"
        getBg(hashMap)
    }
    fun getBg(params:HashMap<String,String>){

            repository.getBgApi(params).observeForever {
                bgLiveData.value = it
            }

    }
}