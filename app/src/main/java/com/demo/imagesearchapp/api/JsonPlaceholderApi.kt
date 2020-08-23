package com.demo.imagesearchapp.api

import com.demo.imagesearchapp.dataclasses.Data
import com.demo.imagesearchapp.dataclasses.Json4Kotlin_Base
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

public interface JsonPlaceholderApi {
    @GET("3/gallery/search/1")
    fun getData(@Query("q") q : String, @Header("Authorization") Authorization:String): Call<Json4Kotlin_Base>
}