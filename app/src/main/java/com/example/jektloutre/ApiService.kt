package com.example.jektloutre

import retrofit.Call
import retrofit.http.GET

interface ApiService {
    @GET("/")
    fun getmessages(): Call<DataModel>
}