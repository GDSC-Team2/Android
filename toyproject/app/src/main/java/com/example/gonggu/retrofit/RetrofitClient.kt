package com.example.gonggu.retrofit

<<<<<<< HEAD
import android.util.Log
import androidx.constraintlayout.widget.Constraints.TAG
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// 싱글턴
object RetrofitClient {
    // 레트로핏 클라이언트 선언
    private var retrofitClient: Retrofit? = null
    
    // 레트로핏 클라이언트 가져오기
    fun getClient(baseUrl: String): Retrofit? {
        Log.d(TAG, "RetrofitClient - getClient() called")

        if(retrofitClient == null) {
            // 레트로핏 빌더를 통해 인스턴스 생성
=======
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// 레트로핏 클라이언트 클래스
// 메모리를 하나 사용하는 싱글턴 패턴을 적용해서 어디서든 하나의 객체를 가져온다.
object RetrofitClient {

    val TAG: String = "로그"

    // 레트로핏 클라이언트 선언

    private var retrofitClient: Retrofit? = null


    // 레트로핏 클라이언트 가져오기
    fun getClient(baseUrl: String): Retrofit? {

        // 만약 레트로핏 클라이이언트가 없으면
        if(retrofitClient == null){

            // 인스턴스 생성
>>>>>>> fc0b6ad4142eba054cd3ccbf9871f11ef3b0e1b1
            retrofitClient = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
<<<<<<< HEAD
        }

        return retrofitClient
    }
=======

        }

        return retrofitClient

    }

>>>>>>> fc0b6ad4142eba054cd3ccbf9871f11ef3b0e1b1
}