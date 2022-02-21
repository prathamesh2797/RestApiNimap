package com.example.nimapinfotech.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nimapinfotech.api.JsonApi
import com.example.nimapinfotech.database.DataDatabase
import com.example.nimapinfotech.models.Data
import com.example.nimapinfotech.models.DataList
import com.example.nimapinfotech.models.Record
import com.example.nimapinfotech.networkconfig.NetworkUtils

class jsonRepository(
    private var jsonApi: JsonApi,
    private val dataDatabase: DataDatabase,
    private var applicationContext: Context
) {


    private val jsonLiveData = MutableLiveData<DataList>()

    val json: LiveData<DataList>
        get()= jsonLiveData

    suspend fun getData(){

        if (NetworkUtils.checkInternetConnection(applicationContext)){
            val result = jsonApi.getJsonList()

            if (result?.body() != null){

                dataDatabase.clearAllTables()
                dataDatabase.getData().addData(result.body()!!.data.Records)
                jsonLiveData.postValue(result.body())
            }

        }else{


            val offlineData = dataDatabase.getData().getData()
            val list = Data(offlineData,1)
            val dataList = DataList("Test",1,list)
            jsonLiveData.postValue(dataList)

        }


    }


}