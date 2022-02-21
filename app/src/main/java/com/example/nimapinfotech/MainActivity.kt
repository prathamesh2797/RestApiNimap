package com.example.nimapinfotech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nimapinfotech.adapter.RVAdapter
import com.example.nimapinfotech.api.JsonApi
import com.example.nimapinfotech.api.RetrofitHelper
import com.example.nimapinfotech.databinding.ActivityMainBinding
import com.example.nimapinfotech.models.Record
import com.example.nimapinfotech.repository.jsonRepository
import com.example.nimapinfotech.viewmodels.MainViewModel
import com.example.nimapinfotech.viewmodels.ViewModelProviderFactory
import retrofit2.HttpException
import java.io.IOException

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    lateinit var rvAdapter : RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var jsonApi = RetrofitHelper.getInstance().create(JsonApi::class.java)

        val repository = (application as Application).dataRepository






        viewModel =ViewModelProvider(this,
        ViewModelProviderFactory(repository)).get(MainViewModel::class.java)

        viewModel.jsonData.observe(this, Observer {list->
            Log.d("Log Data", list.data.toString())

            setUpRecyclerView(list.data.Records)

            lifecycleScope.launchWhenCreated {
                binding.progressBar.isVisible = true
                val response = try{
                    jsonApi.getJsonList()
                }catch (e: IOException){
                    Log.e(TAG, "IO Exception, you might not have active internet connection")
                    binding.progressBar.isVisible = false
                    return@launchWhenCreated
                }catch (e: HttpException){
                    Log.e(TAG, "Http Exception, Unexpected Response from server")
                    binding.progressBar.isVisible = false
                    return@launchWhenCreated
                }

                if (response.isSuccessful && response.body() != null){
                    setUpRecyclerView(list.data.Records)


                }else{
                    setUpRecyclerView(list.data.Records)
                    Log.e(TAG, "Response is not successful")
                }
                binding.progressBar.isVisible = false
            }


            for (records in list.data.Records){
                Log.d("Records", records.title.toString())

            }

        })

    }

    private fun setUpRecyclerView(record : List<Record>){
        rvAdapter = RVAdapter(this,record)
        binding.rvRecyclerView.adapter = rvAdapter
        binding.rvRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

    }
}