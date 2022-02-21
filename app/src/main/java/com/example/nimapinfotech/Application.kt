package com.example.nimapinfotech

import android.app.Application
import com.example.nimapinfotech.api.JsonApi
import com.example.nimapinfotech.api.RetrofitHelper
import com.example.nimapinfotech.database.DataDatabase
import com.example.nimapinfotech.repository.jsonRepository

class Application: Application() {

    lateinit var dataRepository: jsonRepository

    override fun onCreate() {
        super.onCreate()

        initialize()
    }

    public fun initialize(){
        var jsonApi = RetrofitHelper.getInstance().create(JsonApi::class.java)
        val database = DataDatabase.getDatabase(applicationContext)
        dataRepository = jsonRepository(jsonApi,database, applicationContext)

    }
}