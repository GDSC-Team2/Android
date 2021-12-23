package com.example.gonggu.retrofit

import android.util.Log
import androidx.constraintlayout.widget.Constraints.TAG
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// 싱글턴
object RetrofitClient {
    // 레트로핏 클라이언트 선언
    private var retrofitClient: Retrofit? = null

    val TAG: String = "로그"

    // 레트로핏 클라이언트 선언
    fun getClient(baseUrl: String): Retrofit? {
        Log.d(TAG, "RetrofitClient - getClient() called")
        // 만약 레트로핏 클라이이언트가 없으면
        if(retrofitClient == null){
            // 인스턴스 생성
            retrofitClient = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofitClient
    }

}