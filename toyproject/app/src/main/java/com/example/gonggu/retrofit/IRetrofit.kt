package com.example.gonggu.retrofit

<<<<<<< HEAD
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

=======
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
>>>>>>> fc0b6ad4142eba054cd3ccbf9871f11ef3b0e1b1
}