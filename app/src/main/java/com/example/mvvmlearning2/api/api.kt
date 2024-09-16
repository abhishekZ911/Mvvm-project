package com.example.mvvmlearning2.api

import com.example.mvvmlearning2.models.FruitResponseType
import com.example.mvvmlearning2.models.FruitResponseTypeItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface api {

    @GET("/api/fruit/{name}")
    suspend fun getDetails(@Path ("name") name: String) : Response<FruitResponseTypeItem?>
}