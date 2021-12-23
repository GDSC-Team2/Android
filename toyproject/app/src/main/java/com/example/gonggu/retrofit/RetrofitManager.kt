package com.example.gonggu.retrofit

import android.util.Log
import com.example.gonggu.DTOs.userDTO
import com.example.gonggu.model.readDTO
import com.example.gonggu.model.writeDTO
import com.example.gonggu.utils.API.BASE_URL
import com.example.gonggu.utils.Constants.TAG
import retrofit2.Call
import retrofit2.Response


class RetrofitManager {

    companion object {
        val instance = RetrofitManager()
    }

    // 레트로핏 인터페이스 가져오기
    private val httpCall : IRetrofit? = RetrofitClient.getClient(BASE_URL)?.create(IRetrofit::class.java)

    //회원 추가
    fun addUsers(userDTO: userDTO){
        var call = httpCall?.addUsers(userDTO)
        call?.enqueue(object : retrofit2.Callback<userDTO>{
            override fun onResponse(call: Call<userDTO>, response: Response<userDTO>) {
                Log.d(TAG, "성공했다는 뜻 RetrofitManager - onResponse() called / response : $response ")
                Log.d(TAG, "response.body : ${response.body()}")
            }

            override fun onFailure(call: Call<userDTO>, t: Throwable) {
                Log.d(TAG, "실패햇슈 실패햇슈 RetrofitManager - onFailure() called / t: $t ")
            }

        })
    }

    // 유저 검색 api 호출
    fun searchUser(searchTerm: String?, completion: (String) -> Unit) {

        val term = searchTerm.let { it }?: ""

        val call = httpCall?.getUser(searchTerm = term).let {

        }?: return
    }


    //글등록
    fun write(title: String, description: String, link: String, contact: String, date: String){
        var call = httpCall?.write(title,description,link,contact,date)
        call?.enqueue(object : retrofit2.Callback<writeDTO>{
            override fun onResponse(call: Call<writeDTO>, response: Response<writeDTO>) {
                Log.d(TAG, "RetrofitManager - getTodo() - onResponse() called / response: $response")
                Log.d(TAG, "response.body : ${response.body()}")
            }

            override fun onFailure(call: Call<writeDTO>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - getTodo() - onFailure() called / t: ${t}")
            }
        })
    }

    //글 읽기
    fun read(){
        var call = httpCall?.read(id = 1)
        call?.enqueue(object : retrofit2.Callback<readDTO>{
            override fun onResponse(call: Call<readDTO>, response: Response<readDTO>) {
                Log.d(TAG, "RetrofitManager - getTodo() - onResponse() called / response: $response")
                Log.d(TAG, "response.body : ${response.body()}")
            }

            override fun onFailure(call: Call<readDTO>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - getTodo() - onFailure() called / t: ${t}")
            }
        })
    }
}