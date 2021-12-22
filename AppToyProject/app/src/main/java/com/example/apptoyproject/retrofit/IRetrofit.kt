package com.example.gonggu.retrofit

import com.example.gonggu.model.readDTO
import com.example.gonggu.model.writeDTO
import com.example.gonggu.utils.API.Companion.BASE_URL
import retrofit2.http.*

interface IRetrofit {
    @POST("/api/v1/posts")
    fun write(
        @Body writeDTO: String,
        description: String,
        link: String,
        contact: String,
        date: String
    ) : retrofit2.Call<writeDTO>

    @GET("/api/v1/posts/{id}")
    fun read(@Path(value="id",encoded=true) id:Int) : retrofit2.Call<readDTO>

    @PUT("/api/v1/posts/{id}")
    fun modify(
        @Path(value="id",encoded=true) id:Int,
        @Body writeDTO: writeDTO) : retrofit2.Call<writeDTO>

    @DELETE("/api/v1/posts/{id}")
    fun delete(@Path(value="id",encoded=true) id:Int): retrofit2.Call<Void>
}