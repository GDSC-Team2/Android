package com.example.gonggu.retrofit

import com.example.gonggu.utils.API
import retrofit2.create

class RetrofitManager {

    companion object {
        val instance = RetrofitManager()
    }

    // 레트로핏 인터페이스 가져오기
    private val iRetrofit : IRetrofit? = RetrofitClient.getClient(API.BASE_URL)?.create(IRetrofit::class.java)

    // 유저 검색 api 호출
    fun searchUser(searchTerm: String?, completion: (String) -> Unit) {

        val term = searchTerm.let { it }?: ""

        val call = iRetrofit?.getUser(searchTerm = term).let {

        }?: return
    }

}