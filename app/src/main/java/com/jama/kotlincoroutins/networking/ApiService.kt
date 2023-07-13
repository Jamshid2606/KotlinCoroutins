package com.jama.kotlincoroutins.networking

import com.jama.kotlincoroutins.models.UserData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<UserData>
}