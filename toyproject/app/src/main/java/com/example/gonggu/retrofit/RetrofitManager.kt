package com.example.gonggu.retrofit

<<<<<<< Updated upstream
import com.example.gonggu.utils.API
import retrofit2.create
import android.util.Log
import com.example.gonggu.model.readDTO
import com.example.gonggu.model.writeDTO
import com.example.gonggu.utils.API.BASE_URL
import com.example.gonggu.utils.Constants.TAG
import retrofit2.Call
import retrofit2.Response

=======
import android.util.Log
import com.example.gonggu.model.readAllDTO
import com.example.gonggu.model.readDTO
import com.example.gonggu.model.writeDTO
import com.example.gonggu.utils.API
import retrofit2.Call
import retrofit2.Response
>>>>>>> Stashed changes

class RetrofitManager {
    val TAG : String = "로그"

    companion object {
        val instance = RetrofitManager()
    }

    // 레트로핏 인터페이스 가져오기
<<<<<<< Updated upstream
    private val iRetrofit : IRetrofit? = RetrofitClient.getClient(BASE_URL)?.create(IRetrofit::class.java)
=======
    private val iRetrofit : IRetrofit? = RetrofitClient.getClient(API.BASE_URL)?.create(IRetrofit::class.java)
    private val httpCall : IRetrofit? = RetrofitClient.getClient(API.BASE_URL)?.create(IRetrofit::class.java)
>>>>>>> Stashed changes

    // 유저 검색 api 호출
    fun searchUser(searchTerm: String?, completion: (String) -> Unit) {

        val term = searchTerm.let { it }?: ""

        val call = iRetrofit?.getUser(searchTerm = term).let {

        }?: return
    }

<<<<<<< Updated upstream

    private val httpCall : IRetrofit? = RetrofitClient.getClient(BASE_URL)?.create(IRetrofit::class.java)
=======
>>>>>>> Stashed changes

    //글등록
    fun write(writeDTO: writeDTO){
        var call = httpCall?.write(writeDTO)
        call?.enqueue(object : retrofit2.Callback<writeDTO>{
            override fun onResponse(call: Call<writeDTO>, response: Response<writeDTO>) {
                Log.d(TAG, "RetrofitManager - getTodo() - onResponse() called / response: $response")
                Log.d(TAG, "response.body : ${response.body()}")
                Log.d("success", "성공성공")
            }

            override fun onFailure(call: Call<writeDTO>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - getTodo() - onFailure() called / t: ${t}")
                Log.d("fail", "실패실패")
            }
        })
    }



    //세부 글 읽기
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
<<<<<<< Updated upstream
}
=======
}
>>>>>>> Stashed changes
