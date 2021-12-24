package com.example.gonggu

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.gonggu.databinding.ActivityLoginBinding
import com.example.gonggu.databinding.FragmentMySelfPostViewBinding
import com.example.gonggu.databinding.FragmentMypageBinding
import com.example.gonggu.model.MyWritingDTO
import com.example.gonggu.model.readAllDTO
import com.example.gonggu.model.readDTO
import com.example.gonggu.model.writeDTO
import com.example.gonggu.retrofit.IRetrofit
import com.example.gonggu.retrofit.RetrofitClient
import com.example.gonggu.utils.API
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Response

class MyDetailPostView: AppCompatActivity() {
    private val httpCall : IRetrofit? = RetrofitClient.getClient(API.BASE_URL)?.create(IRetrofit::class.java)
    val TAG : String = "로그"

    //뷰 바인딩 사용
    private var mBinding: FragmentMySelfPostViewBinding? = null
    private val binding get() = mBinding!!

    //id값 매칭
    var title=findViewById<TextView>(R.id.et_post_title) //글제목
    var author=findViewById<TextView>(R.id.et_post_writer) //글쓴이
    var price=findViewById<TextView>(R.id.et_price) //공구가격
    var period=findViewById<TextView>(R.id.et_datess) //공구 날짜
    var link=findViewById<TextView>(R.id.et_product_link) //공구링크
    var contact=findViewById<TextView>(R.id.et_messanger_link) //오픈채팅 링크
    var description=findViewById<TextView>(R.id.et_content) //글내용

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        mBinding = FragmentMySelfPostViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent = getIntent();// 인텐트 받아오기
        var authors = intent.getStringExtra("author").toString(); //Adapter에서 받은 키값 연결
        var id_extra=intent.getIntExtra("id_extra",0)

        //세부 글 읽기
        var call = httpCall?.MyWriting(authors)
        call?.enqueue(object : retrofit2.Callback<List<MyWritingDTO>>{
            override fun onResponse(call: Call<List<MyWritingDTO>>, response: Response<List<MyWritingDTO>>) {
                Log.d(TAG, "RetrofitManager - getTodo() - onResponse() called / response: $response")

                //전달받은 position의 정보 받아서 연결
                title.setText(Gson().toJson(response.body()?.get(id_extra)?.title).toString())
                author.setText(Gson().toJson(response.body()?.get(id_extra)?.author).toString())
                link.setText(Gson().toJson(response.body()?.get(id_extra)?.link).toString())
                price.setText(Gson().toJson(response.body()?.get(id_extra)?.price).toString())
                period.setText(Gson().toJson(response.body()?.get(id_extra)?.date).toString())
                contact.setText(Gson().toJson(response.body()?.get(id_extra)?.contact).toString())
                description.setText(Gson().toJson(response.body()?.get(id_extra)?.description).toString())

            }

            override fun onFailure(call: Call<List<MyWritingDTO>>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - getTodo() - onFailure() called / t: ${t}")
            }
        })

        var modified_btn=findViewById<AppCompatButton>(R.id.modified_btn)
        var deleted_btn=findViewById<AppCompatButton>(R.id.del_btn)

        //수정하기 버튼을 눌렀을 때
        modified_btn.setOnClickListener {

            //id값 매칭 & 현재의 입력값 받아서 -> writeDTO 다시 만들기
            var title=findViewById<EditText>(R.id.et_post_title).text.toString() //글제목
            var author=findViewById<TextView>(R.id.et_post_writer).text.toString()  //글쓴이
            var price=findViewById<EditText>(R.id.et_price).text.toString()  //공구가격
            var period=findViewById<EditText>(R.id.et_datess).text.toString()  //공구 날짜
            var link=findViewById<EditText>(R.id.et_product_link).text.toString()  //공구링크
            var contact=findViewById<EditText>(R.id.et_messanger_link).text.toString()  //오픈채팅 링크
            var description=findViewById<EditText>(R.id.et_content).text.toString()  //글내용

            var new_DTO= writeDTO(title, description, link, contact, price, period, author)

            //수정하기
            var call = httpCall?.modify(id=id_extra,new_DTO)
            call?.enqueue(object : retrofit2.Callback<writeDTO>{
                override fun onResponse(call: Call<writeDTO>, response: Response<writeDTO>) {
                    Log.d(TAG, "RetrofitManager - getTodo() - onResponse() called / response: $response")
                    Log.d(TAG, "response.body : ${response.body()}")
                    Toast.makeText(baseContext,"수정완료!", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<writeDTO>, t: Throwable) {
                    Log.d(TAG, "RetrofitManager - getTodo() - onFailure() called / t: ${t}")
                }
            })


        }
        //삭제하기 버튼을 눌렀을 때
        deleted_btn.setOnClickListener {

            //삭제하기
            var call = httpCall?.delete(id=id_extra)
            call?.enqueue(object : retrofit2.Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Log.d(TAG, "RetrofitManager - getTodo() - onResponse() called / response: $response")
                    Log.d(TAG, "response.body : ${response.body()}")
                    Toast.makeText(baseContext,"삭제 완료!", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Log.d(TAG, "RetrofitManager - getTodo() - onFailure() called / t: ${t}")
                }
            })

        }
    }
}