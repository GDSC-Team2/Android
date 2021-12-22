package com.example.gonggu.retrofit

import com.example.gonggu.DTOs.userDTO
import com.example.gonggu.utils.API
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface IRetrofit {

    @POST(API.SEARCH_USERS)
    fun addUser() : Call<userDTO>

    @GET(API.SEARCH_USERS)
    fun getUser(@Query("query") searchTerm: String) : Call<JsonElement>

}