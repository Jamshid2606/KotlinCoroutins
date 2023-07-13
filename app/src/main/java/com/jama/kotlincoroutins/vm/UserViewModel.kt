package com.jama.kotlincoroutins.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jama.kotlincoroutins.models.UserData
import com.jama.kotlincoroutins.networking.ApiClient
import com.jama.kotlincoroutins.networking.ApiService
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class UserViewModel :ViewModel() {
    private val apiService = ApiClient.getRetrofit().create(ApiService::class.java)
    private val liveData = MutableLiveData<List<UserData>>()
    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch{
            try{
                coroutineScope{
                    liveData.postValue(apiService.getUsers())
                }
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
    fun getUsersLiveData():LiveData<List<UserData>>{
        return liveData
    }
}