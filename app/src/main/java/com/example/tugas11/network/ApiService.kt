package com.example.tugas11.network

import com.example.tugas11.model.Maps
import com.example.tugas11.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("agents")
    fun getAllAgent(): Call<Users>

    @GET("maps")
    fun getAllMaps(): Call<Maps>
}