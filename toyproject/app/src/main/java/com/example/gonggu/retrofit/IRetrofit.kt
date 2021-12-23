package com.example.gonggu.retrofit

import com.example.gonggu.DTOs.userDTO
import com.example.gonggu.model.readAllDTO
import com.example.gonggu.model.readDTO
import com.example.gonggu.model.writeDTO
import com.example.gonggu.utils.API
import com.google.gson.JsonElement
import retrofit2.Call
<<<<<<< Updated upstream
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import com.example.gonggu.model.readDTO
import com.example.gonggu.model.writeDTO
import com.example.gonggu.utils.API.SEARCH_USERS
import com.example.gonggu.model.readDTO
import com.example.gonggu.model.writeDTO
import retrofit2.http.*

=======
import retrofit2.http.*
>>>>>>> Stashed changes

interface IRetrofit {

    @POST(SEARCH_USERS)
    fun addUser() : Call<userDTO>

    @GET(SEARCH_USERS)
    fun getUser(@Query("query") searchTerm: String) : Call<JsonElement>

<<<<<<< Updated upstream
=======
    //글등록
    @Headers("Content-Type: application/json")
>>>>>>> Stashed changes
    @POST("/api/v1/posts")
    fun write(
        @Body
        writeDTO: writeDTO
    ) : Call<writeDTO>

    //전체 글 조회
    @GET("/api/v1/posts")
    fun readAll() : Call<List<readAllDTO>>

    //글 세부 조회
    @GET("/api/v1/posts/{id}")
    fun read(@Path(value="id",encoded=true) id:Int) : Call<readDTO>

    @PUT("/api/v1/posts/{id}")
    fun modify(
        @Path(value="id",encoded=true) id:Int,
        @Body writeDTO: writeDTO) : retrofit2.Call<writeDTO>

    @DELETE("/api/v1/posts/{id}")
    fun delete(@Path(value="id",encoded=true) id:Int): retrofit2.Call<Void>
<<<<<<< Updated upstream
}
=======

}

>>>>>>> Stashed changes
