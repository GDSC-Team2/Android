package com.example.gonggu

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gonggu.databinding.FragmentMainDetailBinding
import com.example.gonggu.model.readAllDTO
import com.example.gonggu.recyclerview.MainItem
import com.example.gonggu.recyclerview.MainItemAdapter
import com.example.gonggu.retrofit.IRetrofit
import com.example.gonggu.retrofit.RetrofitClient
import com.example.gonggu.utils.API
import com.google.gson.Gson
import kotlinx.android.synthetic.main.main_items.*
import retrofit2.Call
import retrofit2.Response

class MainDetailFragment : Fragment(){
    //뷰 바인딩 사용
    private var mBinding: FragmentMainDetailBinding? = null
    private val binding get() = mBinding!!

    //recycycler view list
    val MainItemList= arrayListOf<MainItem>()
    val TAG : String = "로그"
    private val httpCall : IRetrofit? = RetrofitClient.getClient(API.BASE_URL)?.create(IRetrofit::class.java)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding= FragmentMainDetailBinding.inflate(inflater, container, false)


        //test recycler view


        //전체 글 읽기
        var call = httpCall?.readAll()
        call?.enqueue(object : retrofit2.Callback<List<readAllDTO>>{
            override fun onResponse(call: Call<List<readAllDTO>>, response: Response<List<readAllDTO>>) {

                Log.d(TAG, "RetrofitManager - getTodo() - onResponse() called / response: $response")
                Log.d(TAG, "response.body : ${response.body()}")
                Log.d(TAG, "response.body : ${response.body()?.size!!}")
                Log.d(TAG, "response.body : ${MainItemList.size}")

                //recycler view 안의 객체 만들기
                    for (i in 0 until response.body()?.size!!){
                        var title1= Gson().toJson(response.body()?.get(i)?.title).toString()
                        var author1=Gson().toJson(response.body()?.get(i)?.author).toString()
                        var link1=Gson().toJson(response.body()?.get(i)?.link).toString()
                        var price1=Gson().toJson(response.body()?.get(i)?.price).toString()
                        var period1=Gson().toJson(response.body()?.get(i)?.date).toString()

                        //recyclerview 연결
                        MainItemList.add(MainItem(title1,author1,link1,price1,period1))
                    }
                Log.d(TAG, "response.body : ${MainItemList.size}")


                //test recycler view
/*
                for (i in 0 .. 4){
                    var title1= Gson().toJson(response.body()?.get(i)?.author).toString()
                    var author1=Gson().toJson(response.body()?.get(i)?.author).toString()
                    var link1=Gson().toJson(response.body()?.get(i)?.link).toString()
                    var price1=Gson().toJson(response.body()?.get(i)?.price).toString()
                    var period1=Gson().toJson(response.body()?.get(i)?.date).toString()

                    //recyclerview 연결
                    MainItemList.add(MainItem("글","글","글","글","글"))
                }



 */
                mBinding!!.rvItems.layoutManager= LinearLayoutManager(activity)
                mBinding!!.rvItems.setHasFixedSize(true)
                mBinding!!.rvItems.adapter= MainItemAdapter(MainItemList)
            }



            override fun onFailure(call: Call<List<readAllDTO>>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - getTodo() - onFailure() called / t: ${t}")
            }
        })

        mBinding!!.rvItems.layoutManager= LinearLayoutManager(activity)
        mBinding!!.rvItems.setHasFixedSize(true)

        mBinding!!.rvItems.adapter= MainItemAdapter(MainItemList)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding=null
    }

    /*
    //전체 글 읽기
    fun readAll(){
        var call = httpCall?.readAll(id)
        call?.enqueue(object : retrofit2.Callback<readAllDTO>{
            override fun onResponse(call: Call<readAllDTO>, response: Response<readAllDTO>) {

                Log.d(TAG, "RetrofitManager - getTodo() - onResponse() called / response: $response")
                Log.d(TAG, "response.body : ${response.body()}")

                //recycler view 안의 객체 만들기
                var title= response.body()?.title
                var author=response.body()?.author
                var link=response.body()?.link
                var price=response.body()?.price
                var period=response.body()?.date

                //recycycler view list
                val MainItemList= arrayListOf<MainItem>()

                if (author != null) {
                    for (i in 0 until author.count()){

                        var title1= title?.get(i).toString()
                        var author1=author?.get(i).toString()
                        var link1=link?.get(i).toString()
                        var price1=price?.get(i).toString()
                        var period1=period?.get(i).toString()
                        MainItemList.add(MainItem(title1,author1,link1,price1,period1))
                    }
                }
            }

            override fun onFailure(call: Call<readAllDTO>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - getTodo() - onFailure() called / t: ${t}")
            }
        })
    }
    */
}