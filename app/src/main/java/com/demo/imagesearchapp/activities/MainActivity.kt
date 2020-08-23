package com.demo.imagesearchapp.activities

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.imagesearchapp.R
import com.demo.imagesearchapp.adapters.ImagesAdapter
import com.demo.imagesearchapp.api.JsonPlaceholderApi
import com.demo.imagesearchapp.dataclasses.Data
import com.demo.imagesearchapp.dataclasses.Json4Kotlin_Base
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    var data: List<Data>? = null
    var TAG : String = javaClass.name
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var rvData = findViewById<View>(R.id.rvData) as RecyclerView
        rvData.layoutManager = GridLayoutManager(this,2)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.imgur.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val jsonPlaceHolderApi: JsonPlaceholderApi = retrofit.create<JsonPlaceholderApi>(
            JsonPlaceholderApi::class.java
        )
        search_bar.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                callApi(query, jsonPlaceHolderApi, this@MainActivity)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    fun callApi (query : String, jsonPlaceholderApi: JsonPlaceholderApi, context: Context) {
        val call: Call<Json4Kotlin_Base> = jsonPlaceholderApi.getData(query,"Client-ID 137cda6b5008a7c")
        Log.d(TAG, "onResponse: ConfigurationListener::"+call.request().header("Authorization"));
        call.enqueue(object : Callback<Json4Kotlin_Base> {
            override fun onResponse(call: Call<Json4Kotlin_Base>, response: Response<Json4Kotlin_Base>) {
                if (response.isSuccessful) {
                    val demo : List<Data>? = response.body()?.data
                    data = demo
                    var adapter = ImagesAdapter(data, context)
                    rvData.adapter = adapter
                    Toast.makeText(this@MainActivity, "Success",Toast.LENGTH_LONG).show()
                    return
                } else {
                    Toast.makeText(this@MainActivity, "No Match found",Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<Json4Kotlin_Base>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Api Failed because : " + t.message,Toast.LENGTH_LONG).show()
            }
        })
    }
}