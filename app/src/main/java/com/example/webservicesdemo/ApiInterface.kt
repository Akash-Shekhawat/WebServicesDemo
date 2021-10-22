package com.example.webservicesdemo

import retrofit2.Call

import retrofit2.http.GET

import retrofit2.http.Path

interface ApiInterface {
    @GET("posts")
    fun getData(): Call<List<MyDataItem>>

}