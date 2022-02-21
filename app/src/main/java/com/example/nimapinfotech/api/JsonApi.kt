package com.example.nimapinfotech.api

import com.example.nimapinfotech.models.DataList
import retrofit2.Response
import retrofit2.http.GET

interface JsonApi {

    @GET("/testdata.json")
    suspend fun getJsonList(): Response<DataList>
}